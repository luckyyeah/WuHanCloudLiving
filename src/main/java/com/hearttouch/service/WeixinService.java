/*
 * Create Author  : huajie.duan
 * Create Date    : 2015-07-29
 * Project        : venus
 * File Name      : WeixinService.java
 *
 * Copyright (c) 2010-2015 by Shanghai XinChuDong Co., Ltd.
 * All rights reserved.
 *
 */
package com.hearttouch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hearttouch.entity.GlobalConfig;
import com.hearttouch.util.DateUtil;
import com.hearttouch.util.WeixinUtils;

/**
 * 功能描述:  <p>
 *
 * @author : huajie.duan <p>
 * @version 1.0 2015-07-29
 * @since venus 1.0
 */
@Service("weixinService")
public class WeixinService extends BaseService {

    @Autowired
    private GlobalConfigService globalConfigService;

    public String getAccessToken() {
        String accessToken = null;
        try {
            GlobalConfig tokenConfig = globalConfigService.getValue("access_token");
            if (tokenConfig != null && tokenConfig.getUpdateTime().compareTo(DateUtil.getAfterHourDate(-1)) > 0) {
                return tokenConfig.getValue();
            } else {
                accessToken = WeixinUtils.getAccessTokenFromWeixin();
                if (tokenConfig != null) {
                    globalConfigService.setValue("access_token", accessToken);
                } else {
                    globalConfigService.addConfig("access_token", accessToken);
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return accessToken;
    }

}
