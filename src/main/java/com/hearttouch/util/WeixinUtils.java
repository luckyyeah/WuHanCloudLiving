/*
 * Create Author  : huajie.duan
 * Create Date    : 2015-07-30
 * Project        : venus
 * File Name      : WeixinUtils.java
 *
 * Copyright (c) 2010-2015 by Shanghai XinChuDong Co., Ltd.
 * All rights reserved.
 *
 */
package com.hearttouch.util;

import com.alibaba.fastjson.JSON;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 功能描述:  <p>
 *
 * @author : huajie.duan <p>
 * @version 1.0 2015-07-30
 * @since venus 1.0
 */
public class WeixinUtils {
    private static Logger logger = Logger.getLogger(WeixinUtils.class);

    public static String getAccessTokenFromWeixin() throws Exception {
        String body = HttpRequest.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" +
                Const.WX_APP_ID + "&secret=" + Const.WX_APP_SECRET).body();
        Map result = JSON.parseObject(body, Map.class);
        String accessToken = (String) result.get("access_token");
        if (accessToken == null) {
            throw new Exception(result.toString());
        }
        return accessToken;
    }

    public static boolean checkSignature(String sign, String timestamp, String nonce) {
        ArrayList<String> params = Lists.newArrayList(Const.WX_TOKEN, timestamp, nonce);
        Collections.sort(params);
        return DigestUtils.sha1Hex(Joiner.on("").join(params)).equals(sign);
    }

    public static String nonceStr() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String buildOAuthUrl(String url) throws UnsupportedEncodingException {
        String encodedUrl = URLEncoder.encode(url, "UTF8");
        return new StringBuilder().append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=")
                .append(Const.WX_APP_ID).append("&redirect_uri=").append(encodedUrl)
                .append("&response_type=code&scope=snsapi_base&state=1#wechat_redirect").toString();
    }

    public static String generatePayJson(String tradeNo, String openId, String description, int totalPrice, String userIp) throws DocumentException {
        long timestamp = DateUtil.getUnixTime();
        String nonceStr = nonceStr();
        String pkg = generatePackage(tradeNo, openId, description, totalPrice, userIp, nonceStr);

        if (pkg == null) {
            return null;
        }

        String paySign = generatePaySign(pkg, nonceStr, timestamp);

        Map<String, String> params = Maps.newLinkedHashMap();
        params.put("appId", Const.WX_APP_ID);
        params.put("timeStamp", String.valueOf(timestamp));
        params.put("nonceStr", nonceStr);
        params.put("package", pkg);
        params.put("signType", "MD5");
        params.put("paySign", paySign);
        return JSON.toJSONString(params);
    }

    private static String generatePaySign(String pkg, String nonceStr, long timestamp) {
        Map<String, String> signDict = Maps.newHashMap();
        signDict.put("appId", Const.WX_APP_ID);
        signDict.put("timeStamp", String.valueOf(timestamp));
        signDict.put("nonceStr", nonceStr);
        signDict.put("package", pkg);
        signDict.put("signType", "MD5");

        List<String> keys = Lists.newArrayList(signDict.keySet());
        Collections.sort(keys);

        List<String> kv = Lists.newArrayList();
        for (String key : keys) {
            kv.add(key + "=" + signDict.get(key));
        }
        String str = Joiner.on("&").join(kv);
        String signTmp = str + "&key=" + Const.WX_PARTNER_KEY;
        return DigestUtils.md5Hex(signTmp);
    }

    private static String generatePackage(String tradeNo, String openId, String description, int totalPrice, String userIp, String nonceStr) throws DocumentException {
        Map<String, String> pkg = Maps.newHashMap();
        pkg.put("appid", Const.WX_APP_ID);
        pkg.put("mch_id", Const.WX_PARTNER_ID);
        pkg.put("body", description);
        pkg.put("out_trade_no", tradeNo);
        pkg.put("total_fee", String.valueOf(totalPrice));
        pkg.put("spbill_create_ip", userIp);
        pkg.put("notify_url", Const.WX_PAY_NOTIFY_URL);
        pkg.put("trade_type", "JSAPI");
        pkg.put("nonce_str", nonceStr);
        pkg.put("openid", openId);

        List<String> keys = Lists.newArrayList(pkg.keySet());
        Collections.sort(keys);

        List<String> kv = Lists.newArrayList();
        for (String key : keys) {
            kv.add(key + "=" + pkg.get(key));
        }
        String str = Joiner.on("&").join(kv);
        String signTmp = str + "&key=" + Const.WX_PARTNER_KEY;
        String sign = DigestUtils.md5Hex(signTmp);
        pkg.put("sign", sign);

        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("xml");

        root.addElement("appid").addText(pkg.get("appid"));
        root.addElement("body").addText(pkg.get("body"));
        root.addElement("mch_id").addText(pkg.get("mch_id"));
        root.addElement("nonce_str").addText(pkg.get("nonce_str"));
        root.addElement("notify_url").addText(pkg.get("notify_url"));
        root.addElement("out_trade_no").addText(pkg.get("out_trade_no"));
        root.addElement("total_fee").addText(pkg.get("total_fee"));
        root.addElement("spbill_create_ip").addText(pkg.get("spbill_create_ip"));
        root.addElement("trade_type").addText(pkg.get("trade_type"));
        root.addElement("openid").addText(pkg.get("openid"));
        root.addElement("sign").addText(pkg.get("sign"));

        String body = HttpRequest.post(Const.WX_PAY_URL).send(document.asXML()).body();
        logger.info(body);
        root = DocumentHelper.parseText(body).getRootElement();
        for (Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            if (element.getName().equals("prepay_id")) {
                return "prepay_id=" + element.getText();
            }
        }
        return null;
    }

    /**
     * Give body, parse result to `result` map
     *
     * @param body
     * @param result
     * @throws DocumentException
     */
    public static void parseWxMessage(String body, Map<String, String> result) throws DocumentException {
        Element root = DocumentHelper.parseText(body).getRootElement();
        for (Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            result.put(element.getName(), element.getText());
        }
    }

    /**
     * Warning: This function need to visit weixin websites
     *
     * @return
     */
    public static String getOpenIdByCode(String code) {
        Map<String, String> params = Maps.newHashMap();
        params.put("appid", Const.WX_APP_ID);
        params.put("secret", Const.WX_APP_SECRET);
        params.put("code", code);
        params.put("grant_type", "authorization_code");
        String body = HttpRequest.get("https://api.weixin.qq.com/sns/oauth2/access_token", params, true).body();

        Map result = JSON.parseObject(body, Map.class);
        return (String) result.get("openid");
    }

    public static String buildTextMessage(String userOpenId, String content) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("xml");
        root.addElement("ToUserName").addCDATA(userOpenId);
        root.addElement("FromUserName").addCDATA(Const.WX_RAW_ID);
        root.addElement("CreateTime").addText(String.valueOf(DateUtil.getUnixTime()));
        root.addElement("MsgType").addCDATA("text");
        root.addElement("Content").addCDATA(content);
        String xml = document.asXML();
        try {
            return new String(xml.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }
        return xml;
    }
}
