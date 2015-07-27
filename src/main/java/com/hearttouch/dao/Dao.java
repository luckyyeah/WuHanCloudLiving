/*
 * Create Author  : huajie.duan
 * Create Date    : 2015-05-12
 * Project        : hjduan
 * File Name      : Dao.java
 *
 * Copyright (c) 2010-2015 by Shanghai HanTao Information Co., Ltd.
 * All rights reserved.
 *
 */
package com.hearttouch.dao;

/**
 * 功能描述:  <p>
 *
 * @author : huajie.duan <p>
 * @version 1.0 2015-05-12
 * @since hjduan 1.0
 */

public interface Dao {

    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object save(String str, Object obj) throws Exception;

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object update(String str, Object obj) throws Exception;

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object delete(String str, Object obj) throws Exception;

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForObject(String str, Object obj) throws Exception;

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForList(String str, Object obj) throws Exception;

    /**
     * 查找对象封装成Map
     * @param s
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForMap(String sql, Object obj, String key , String value) throws Exception;

}
