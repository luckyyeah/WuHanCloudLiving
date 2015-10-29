/*
 * Create Author  : huajie.duan
 * Create Date    : 2015-08-04
 * Project        : venus
 * File Name      : BaseService.java
 *
 * Copyright (c) 2013-2015 by Shanghai XinChuDong Co., Ltd.
 * All rights reserved.
 *
 */
package com.hearttouch.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.hearttouch.dao.DaoSupport;
import com.hearttouch.dao.DaoSupportEx;

/**
 * 功能描述:  <p>
 *
 * @author : huajie.duan <p>
 * @version 1.0 2015-08-04
 * @since venus 1.0
 */
public class BaseService {

	@Resource(name = "daoSupportEx")
	protected DaoSupportEx dao;

    protected Logger logger = Logger.getLogger(BaseService.class);

}
