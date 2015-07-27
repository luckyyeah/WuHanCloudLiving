package com.hearttouch.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.marker.weixin.DefaultSession;
import org.marker.weixin.HandleMessageAdapter;
import org.marker.weixin.MySecurity;
import org.marker.weixin.msg.Data4Item;
import org.marker.weixin.msg.Msg4Event;
import org.marker.weixin.msg.Msg4Image;
import org.marker.weixin.msg.Msg4ImageText;
import org.marker.weixin.msg.Msg4Link;
import org.marker.weixin.msg.Msg4Location;
import org.marker.weixin.msg.Msg4Text;
import org.marker.weixin.msg.Msg4Video;
import org.marker.weixin.msg.Msg4Voice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hearttouch.controllers.base.BaseController;
import com.hearttouch.entity.Page;
import com.hearttouch.util.Const;
import com.hearttouch.util.PageData;
import com.hearttouch.util.Tools;


@Controller
@RequestMapping(value="/weixin")
public class WeixinController extends BaseController{
	
	/**
	 * 接口验证,总入口
	 * @param out
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	 @RequestMapping(value="/index")
	 public void index(
			 PrintWriter out,
			 HttpServletRequest request,
			 HttpServletResponse response
			 ) throws Exception{     
		 logBefore(logger, "微信接口");
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			String signature = pd.getString("signature");		//微信加密签名
			String timestamp = pd.getString("timestamp");		//时间戳
			String nonce	 = pd.getString("nonce");			//随机数
			String echostr 	 = pd.getString("echostr");			//字符串

			if(null != signature && null != timestamp && null != nonce && null != echostr){/* 接口验证  */
				logBefore(logger, "进入身份验证");
			    List<String> list = new ArrayList<String>(3) { 
				    private static final long serialVersionUID = 2621444383666420433L; 
				    public String toString() {  // 重写toString方法，得到三个参数的拼接字符串
				               return this.get(0) + this.get(1) + this.get(2); 
				           } 
				         }; 
				    //TODO微信token
				   list.add(Const.WEIXIN_TOKEN); 		//读取Token(令牌)
				   list.add(timestamp); 
				   list.add(nonce); 
				   Collections.sort(list);							// 排序 
				   String tmpStr = new MySecurity().encode(list.toString(), 
				    MySecurity.SHA_1);								// SHA-1加密 
				   
				    if (signature.equals(tmpStr)) { 
				           out.write(echostr);						// 请求验证成功，返回随机码 
				     }else{ 
				           out.write(""); 
			       } 
				out.flush();
				out.close(); 
			}else{/* 消息处理  */
				logBefore(logger, "进入消息处理");
				response.reset();
				sendMsg(request,response);
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
	}
	 /**
	  * 处理微信服务器发过来的各种消息，包括：文本、图片、地理位置、音乐等等 
	  * @param request
	  * @param response
	  * @throws Exception
	  */
	 public void sendMsg(HttpServletRequest request, HttpServletResponse response) throws Exception{ 

         InputStream is = request.getInputStream(); 
         OutputStream os = response.getOutputStream(); 

         final DefaultSession session = DefaultSession.newInstance(); 
         session.addOnHandleMessageListener(new HandleMessageAdapter(){ 
        	 
        	/**
        	 * 事件
        	 */
        	@Override
        	public void onEventMsg(Msg4Event msg) {
        		/** msg.getEvent()
        		 * unsubscribe：取消关注 ; subscribe：关注
        		 */
        		if("subscribe".equals(msg.getEvent())){
        			returnMSg(msg,null,"关注");
        		}
        	}
        	
        	 /**
        	  * 收到的文本消息
        	  */
        	 @Override 
             public void onTextMsg(Msg4Text msg) { 
                returnMSg(null,msg,msg.getContent().trim());
             }
        	 
        	 @Override
        	public void onImageMsg(Msg4Image msg) {
        		// TODO Auto-generated method stub
        		super.onImageMsg(msg);
        	}
        	 
        	 @Override
        	public void onLocationMsg(Msg4Location msg) {
        		// TODO Auto-generated method stub
        		super.onLocationMsg(msg);
        	}
        	 
        	@Override
        	public void onLinkMsg(Msg4Link msg) {
        		// TODO Auto-generated method stub
        		super.onLinkMsg(msg);
        	}
        	
        	@Override
        	public void onVideoMsg(Msg4Video msg) {
        		// TODO Auto-generated method stub
        		super.onVideoMsg(msg);
        	}
        	
        	@Override
        	public void onVoiceMsg(Msg4Voice msg) {
        		// TODO Auto-generated method stub
        		super.onVoiceMsg(msg);
        	}
        	
        	@Override
        	public void onErrorMsg(int errorCode) {
        		// TODO Auto-generated method stub
        		super.onErrorMsg(errorCode);
        	}
        	
        	/**
        	 * 返回消息
        	 * @param emsg
        	 * @param tmsg
        	 * @param getmsg
        	 */
        	public void returnMSg(Msg4Event emsg, Msg4Text tmsg, String getmsg){
        		
        	}
        	
        }); 

         /*必须调用这两个方法   如果不调用close方法，将会出现响应数据串到其它Servlet中。*/ 
         session.process(is, os);	//处理微信消息  
         session.close();			//关闭Session 
     } 


	//================================================获取关注列表==============================================================
	public final static String openId_url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	//获取access_token
	@RequestMapping(value="/getOpenId")
	public void getOpenId(PrintWriter out) {
		logBefore(logger, "获取关注列表");
		try{
			String access_token =null;//getAt(out);
			String redirect_uri ="http://203.195.155.116/FHMYSQL/weixin/showIndex";
			String ENCODING="utf-8";
			redirect_uri= URLEncoder.encode(redirect_uri);
			System.out.println(access_token+"============");
			
			String requestUrl=openId_url.replace("ACCESS_TOKEN", access_token);
			String appid = "wxb8521e23937b6789";
			String appsecret = "18794f89ea3b7d5490684a8b71a2c7ea";			
			requestUrl=requestUrl.replace("APPID", appid).replace("APPSECRET", appsecret);
			requestUrl=requestUrl.replace("REDIRECT_URI", redirect_uri);
			requestUrl=requestUrl.replace("SCOPE", "snsapi_base");
			requestUrl=requestUrl.replace("STATE", get32UUID());
			System.out.println(requestUrl+"============");
			
			JSONObject jsonObject = httpRequst(requestUrl, "GET", null);
			System.out.println(jsonObject.getString("unionid"));
			//System.out.println(jsonObject.getString("total")+"============");
			
			/*PrintWriter pw;
			try {
				pw = new PrintWriter( new FileWriter( "e:/gz.txt" ) );
				pw.print(jsonObject.getString("total"));
		        pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.write("success");
			out.close();*/
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
	}	


	public static JSONObject httpRequst(String requestUrl,String requetMethod,String outputStr){
		JSONObject jsonobject=null;
		StringBuffer buffer=new StringBuffer();
		try
		{
			//创建SSLContext对象，并使用我们指定的新人管理器初始化
			TrustManager[] tm={new MyX509TrustManager()};
			SSLContext sslcontext=SSLContext.getInstance("SSL","SunJSSE");
			sslcontext.init(null, tm, new java.security.SecureRandom());
			//从上述SSLContext对象中得到SSLSocktFactory对象
			SSLSocketFactory ssf=sslcontext.getSocketFactory();
			
			URL url=new URL(requestUrl);
			HttpsURLConnection httpUrlConn=(HttpsURLConnection)url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			//设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requetMethod);
			
			if("GET".equalsIgnoreCase(requetMethod))
				httpUrlConn.connect();
			
			//当有数据需要提交时
			if(null!=outputStr)
			{
			OutputStream outputStream=httpUrlConn.getOutputStream();
			//注意编码格式，防止中文乱码
			outputStream.write(outputStr.getBytes("UTF-8"));
			outputStream.close();
			}
			
			//将返回的输入流转换成字符串
			InputStream inputStream=httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			
			
			String str=null;
			while((str = bufferedReader.readLine()) !=null)
			{ 
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			//释放资源
			inputStream.close();
			inputStream=null;
			httpUrlConn.disconnect();
			jsonobject=JSONObject.fromObject(buffer.toString());
		}
		catch (ConnectException ce) {
			// TODO: handle exception
		}
		catch (Exception e) {  
		}
		return jsonobject;
	}
	//================================================获取access_token==============================================================
}


//================================================获取access_token==============================================================
 class MyX509TrustManager implements X509TrustManager
{

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}
}
//================================================获取access_token==============================================================