package com.hearttouch.controllers;

import net.sf.json.JSONObject;

import com.hearttouch.util.Const;

public class TestTemlete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     	String access_token_url ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	          	//获取REFRESH_TOKEN 开始
	    		String requestUrl=access_token_url.replace("APPID",Const.APPID);
	    		requestUrl =requestUrl.replace("APPSECRET", Const.APP_SECRET);

	    		JSONObject jsonObject = WeixinController.httpRequst(requestUrl, "GET", null);
	    		String access_token = jsonObject.getString("access_token");
	    		/* 	String template_apply_url ="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
	    		 requestUrl=template_apply_url.replace("ACCESS_TOKEN",access_token);
	    		 String output ="{\"industry_id1\":\"1\",\"industry_id2\":\"21\"}";
	    		jsonObject = WeixinController.httpRequst(requestUrl, "POST", output);
	    		// String access_token2 = jsonObject.getString("access_token"); 
   		       String template_id_rl  = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
	    		 requestUrl=template_id_rl.replace("ACCESS_TOKEN",access_token);
	    		String  output ="{\"template_id_short\":\"OPENTM207102527\"}";
	    		 jsonObject = WeixinController.httpRequst(requestUrl, "POST", output);
	    		 String template_id = jsonObject.getString("template_id");*/
	    		// String jsonText="{"touser":"OPENID","template_id":"templateId","url":"","topcolor":"#FF0000","data":{"first": {"value":"firstData","color":"#173177"},"product": {"value":"productData","color":"#173177"},"price": {"value":"priceData","color":"#173177"},"time": {"value":"timeData","color":"#173177"},"remark": {"value":"remarkData","color":"#173177"}}}";
	             
	    		 String post_message_url  = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	    		 requestUrl=post_message_url.replace("ACCESS_TOKEN",access_token);

	    		 
	    		    MsgTemplate msgTemplate = new MsgTemplate();
	    	        msgTemplate.setTouser("oAULZwp8n1ZtBegw5Q1qkdFBP0W4");
	    	        msgTemplate.setTemplate_id("lVf5K5qNs-lbXbzXmXe3XqhldJywtelCylvUzN2pvcY");
	    	        msgTemplate.setTopcolor("#000000");
	    	        msgTemplate.setUrl("");
	    	        msgTemplate.addTextField("first", "binbin");
	    	        msgTemplate.addTextField("keyword1", "2014年05月02日", "#ff00ff");
	    	        msgTemplate.addTextField("keyword2", "姓名变更", "#ff00ff");
	    	        msgTemplate.addTextField("keyword3", "待受理", "#ff00ff");
	    	        System.out.println(msgTemplate.toJson());
	    	        String post_message = msgTemplate.toJson();
	    		 jsonObject = WeixinController.httpRequst(requestUrl, "POST", post_message);
	 
	    		String  testURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxee246a902fc30075&redirect_uri=http%3A%2F%2Fcms.xincdmedia.com:8080%2FWuHanCloudLiving%2FaddStudentInfo&response_type=code&scope=snsapi_userinfo#wechat_redirect";
	    		 jsonObject = WeixinController.httpRequst(testURL, "get", null);
	    	        
	    		 String error_code = jsonObject.getString("error_code");

	}

}
