/*
 * Create Author  : huajie.duan
 * Create Date    : 2015-08-24
 * Project        : venus
 * File Name      : GlobalConfigService.java
 *
 * Copyright (c) 2013-2015 by Shanghai XinChuDong Co., Ltd.
 * All rights reserved.
 *
 */
package com.hearttouch.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hearttouch.entity.GlobalConfig;

/**
 * 功能描述:  <p>
 *
 * @author : huajie.duan <p>
 * @version 1.0 2015-08-24
 * @since venus 1.0
 */
@Service("globalConfigService")
public class GlobalConfigService extends BaseService {

    public GlobalConfig getValue(String key) throws Exception {
        return (GlobalConfig) dao.findForObject("GlobalConfigMapper.select", key);
    }

    public boolean setValue(String key, String value) throws Exception {
        Map<String, String> params = Maps.newHashMap();
        params.put("key", key);
        params.put("value", value);
        return (Integer) dao.update("GlobalConfigMapper.update", params) > 0;
    }

    public boolean addConfig(String key, String value) throws Exception {
        Map<String, String> params = Maps.newHashMap();
        params.put("key", key);
        params.put("value", value);
        return (Integer) dao.save("GlobalConfigMapper.insert", params) > 0;
    }

}
