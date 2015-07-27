package com.hearttouch.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class CommonUtil {
	 private static final Log log = LogFactory.getLog(CommonUtil.class); 
	public static String PROPERTY_FILE = "schoolInfo.properties";
	public static String getProperty(String path,String keyName)   {
		String value = "";
		try{
	
			InputStream ins = CommonUtil.class.getClassLoader().getResourceAsStream(path);
			
			Properties properties = new Properties();
			properties.load(ins);
			value = properties.getProperty(keyName);
			ins.close();
		}catch(Exception ex) {
			 log.error("#ERROR# :系统加载"+path+"配置文件异常，请检查！", ex); 
		}
		return value;
	}
	public static String getProperty(String keyName) throws IOException  {

		return getProperty(PROPERTY_FILE,keyName);
	}
	
}
