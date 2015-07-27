package com.hearttouch.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * Created by xiaobin on 2/13/15.
 */
public class MsgTemplate implements Serializable {

    private static final long serialVersionUID = 3132269950618303986L;
    private String touser;
    private String template_id;
    private String url;
    private String topcolor;

    public static MsgTemplate sendNewMsg(String touser, String template_id, String url) {
        return new MsgTemplate(touser, template_id, url);
    }

    public static MsgTemplate sendNewMsg(String touser, String template_id, String url, String topcolor) {
        return new MsgTemplate(touser, template_id, url, topcolor);
    }

    private Map<String, TextField> data = new HashMap<String, TextField>();

    public MsgTemplate() {

    }

    private MsgTemplate(String touser, String template_id, String url) {
        this.touser = touser;
        this.template_id = template_id;
        this.url = url;
    }

    private MsgTemplate(String touser, String template_id, String url, String topcolor) {
        this.touser = touser;
        this.template_id = template_id;
        this.url = url;
        this.topcolor = topcolor;
    }

    public MsgTemplate addTextField(String dataName, String value) {
        return addTextField(dataName, value, null);
    }

    public MsgTemplate addTextField(String dataName, String value, String color) {
        data.put(dataName, new TextField(value, color));
        return this;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public Map<String, TextField> getData() {
        return data;
    }

    public void setData(Map<String, TextField> data) {
        this.data = data;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
/*
    public int pushMsg() {
        return WeixinMsgService.pushMsg(this);
    }*/


    public static void main(String args[]) {
        MsgTemplate msgTemplate = new MsgTemplate();
        msgTemplate.setTouser("oAULZwp8n1ZtBegw5Q1qkdFBP0W4");
        msgTemplate.setTemplate_id("6BDLL9mveyqFctWGv96xOe8H_KHqzNHsrOW5RuvtCCg");
        msgTemplate.setTopcolor("#000000");
        msgTemplate.setUrl("");
        msgTemplate.addTextField("first", "binbin");
        msgTemplate.addTextField("keyword1", "2014年05月02日", "#ff00ff");
        msgTemplate.addTextField("keyword2", "姓名变更", "#ff00ff");
        msgTemplate.addTextField("keyword3", "待受理", "#ff00ff");
        System.out.println(msgTemplate.toJson());
       //msgTemplate.pushMsg();

/*        MsgTemplate.sendNewMsg("toUserId", "tempId", "http://www.baidu.com")
                .addTextField("first", "binbin")
                .addTextField("sex", "男人", "#ff00ff")
                .pushMsg();*/

        System.out.println(msgTemplate.toJson());

    }
}
