package com.hearttouch.util;

import org.springframework.context.ApplicationContext;
/**
 * 项目名称：
 * @author:
 * 
*/
public class Const {
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String SESSION_menuList = "menuList";			//当前菜单
	public static final String SESSION_allmenuList = "allmenuList";		//全部菜单
	public static final String SESSION_QX = "QX";
	public static final String SESSION_userpds = "userpds";			
	public static final String SESSION_USERROL = "USERROL";				//用户对象
	public static final String SESSION_USERNAME = "USERNAME";			//用户名
	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String LOGIN = "/login_toLogin.do";				//登录地址
	public static final String SYSNAME = "admin/config/SYSNAME.txt";	//系统名称路径
	public static final String PAGE	= "admin/config/PAGE.txt";			//分页条数配置路径
	public static final String FILEPATHIMG = "uploadFiles/uploadImgs/";	//图片上传路径
	public static final String FILEPATHFILE = "uploadFiles/file/";		//文件上传路径
	public static final String WORKFLOW_FILEPATH = "workflow";		//WORKFLOW路径
	public static final String WORKFLOW_SETFILE = "workflow.properties";		//WORKFLOW路径
	public static final String FILEPATHTWODIMENSIONCODE = "uploadFiles/twoDimensionCode/"; //二维码存放路径
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(deviceMonitor)|(static)|(fallback)|(api)|(activate)|(upload)|(main)|(websocket)).*";	//不对匹配该值的访问路径拦截（正则）
	public static final String BASEPATH = "basePath";	//根目录下路径
	public static final String CODE_TYPE_STATUS = "1";	//发布状态
	public static final String CODE_TYPE_OPERATION_ID = "2";	//发布状态
	public static final String CODE_TYPE_APPROVE_STATUS = "3";	//审批结果状态
	public static final String APPLY_USER_ID  = "applyUserId";	//	申请者
	public static final String MANAGE_ID      = "manageId";	//	总经理
	public static final String USER_ID        = "userid";	//	总经理
	public static final String APP_APPROVE_PROCESS = "ProcessWorkFlow";	//	海报审批流程
	public static final String APP_GROUPS_ID = "GroupsId";	//	海报审批流程
	public static final String APPROVE_PASS = "approvePass";	//	审批通过标示
	public static final String REAPPLY_FLAG = "reApply";	//	重新申请标示
	public static final String APPLY_FLAG_HAVE    = "1";	//	审批需要标示
	public static final String STATUS_APPLYING = "0";	//	申请中
	public static final String STATUS_APPROVING = "1";	//	审批中
	public static final String STATUS_COMPLETE = "2";	//	审批完成	
	public static final String STATUS_REJECT = "-1";	//	被拒绝		
	public static final String STATUS_REREPLY = "3";	    //	重新审批
	public static final String STATUS_CANCEL = "4";	    //	取消	
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化
	public static final String DEVICE_ONLINE = "0";	    //	设备在线
	public static final String DEVICE_OFFLINE = "-1";	    //	设备离线
	public static final String OPERATION_ID_POST = "2";	    //	海报方案
	public static final String OPERATION_ID_VIDEO = "1";	    //	视频方案
	public static final String OPERATION_ID_APPPLAN = "3";	    //	APP方案
	public static final String OPERATION_ID_APP = "4";	    //	APP方案
	public static final int  PUBLISH_STTATUS_APPROVED = 2;	    //	方案通过
	public static final int  PUBLISH_STTATUS_REJECTEDED =-1;	    //审批未通过	
	public static final int  PUBLISH_STTATUS_APPROVING  =1;	    //审批中	
	public static final int  PUBLISH_STTATUS_NO_APPLY =0;	    //未提交审批
	public static final String WEIXIN_TOKEN ="ABCD123456";
	//微信公众号APPID
	public final static String APPID="wxee246a902fc30075";
	public final static String APPID_XINCD="wx47614a7fc7cd9c94";
	//微信公众号AppSecret
	public final static String APP_SECRET="80fd2a424dfddd4baceca1a824564e9e";
	public final static String APP_SECRET_XINCD="c1c4ebfe2281191d79e1a15f26d34ee8";
	//获取REFRESH_TOKEN的URL
	public final static String REFRESH_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//获取ACCESS_TOKEN的URL
	public final static String ACCESS_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	//获取用户信息的URL
	public final static String USER_INFO_URL="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public final static String DIRECT_ACCESS_TOKEN_URL ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public final static  String POST_TEMPLETE_MESSAGE_URL  = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	public final static  String SNSAPI_BASE_URL  = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base#wechat_redirect";
	public final static  String SNSAPI_USERINFO_URL  = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_userinfo#wechat_redirect";
	public final static  String MESSAGE_TEMPLATE_ID ="lVf5K5qNs-lbXbzXmXe3XqhldJywtelCylvUzN2pvcY";
	public final static  String MESSAGE_TEMPLATE_ID_XINCD ="MgrGKnQviXE6MsE3BqqUHdAfbtQAHY5FXzg91TkqzZQ";
	public final static  String MESSAGE_REMARK="寝室报修提交已成功，学校管理人员将会尽快和您联系!";
	public final static  String SNSAPI_USERINFO_REDIRECT_URI="http%3A%2F%2Fcms.xincdmedia.com%3A8080%2FWuHanCloudLiving%2FaddStudentInfo";
	public final static  String SNSAPI_BASE_REDIRECT_URI="http%3A%2F%2Fcms.xincdmedia.com%3A8080%2FWuHanCloudLiving%2FshowIndex";
	public final static  String FROM_SITE_XINCD="1";
    public static final String WX_WELCOME_WORDS = "欢迎加入心触动";

    public static final String WX_RAW_ID = "gh_a0041aff8c2a";

    public static final String WX_APP_ID = "wx47614a7fc7cd9c94";

    public static final String WX_APP_SECRET = "c1c4ebfe2281191d79e1a15f26d34ee8";

    public static final String WX_TOKEN = "hjduantest";

    public static final String WX_PARTNER_ID = "1230879602";

    public static final String WX_PAY_NOTIFY_URL = "http://venus.hjduan.com/order/wx_pay_feedback/";

    public static final String WX_PARTNER_KEY = "1qaz2wsx3edc4rfv5tgb6yhn7ujm8ik9";

    public static final String WX_PAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    public static final String WX_RED_PACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

    public static final String WX_PAY_CART_FILE = "/usr/local/tomcat7/weixin/apiclient_cert.p12";
}

