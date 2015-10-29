/*
 * Create Author  : huajie.duan
 * Create Date    : 2015-08-24
 * Project        : venus
 * File Name      : GlobalConfig.java
 *
 * Copyright (c) 2013-2015 by Shanghai XinChuDong Co., Ltd.
 * All rights reserved.
 *
 */
package com.hearttouch.entity;

/**
 * 功能描述:  <p>
 *
 * @author : huajie.duan <p>
 * @version 1.0 2015-08-24
 * @since venus 1.0
 */
public class GlobalConfig {

    private long configId;

    private String key;

    private String value;

    private String addTime;

    private String updateTime;

    public long getConfigId() {
        return configId;
    }

    public void setConfigId(long configId) {
        this.configId = configId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
