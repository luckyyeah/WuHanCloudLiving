package com.hearttouch.exception;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.hearttouch.util.Logger;


/**
* <p>Title: XincdHandlerExceptionResolver.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2015<／p>
* <p>Company: xincd<／p>
* @author Yeah
* @date 2015年6月27日
* @version 1.0
*/
public class XincdHandlerExceptionResolver implements
		HandlerExceptionResolver {


	protected Logger logger = Logger.getLogger(this.getClass());
    @Override  
    public ModelAndView resolveException(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex) {  
    	//日志文件中输出异常内容
        logger.error("Exception: ",ex);
        //取得异常信息
        ExcepitonMessage exMsg = new ExcepitonMessage();  
        ex.printStackTrace(exMsg);  
        //异常页面中显示异常信息
        ModelAndView mv = new ModelAndView();
		mv.setViewName("system/error");
		mv.addObject("errorMsg", exMsg.getString());    		
    	return mv;
    }  

}
