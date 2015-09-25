package com.hearttouch.controllers;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hearttouch.controllers.base.BaseController;
import com.hearttouch.entity.DormRepairEntity;
import com.hearttouch.entity.Page;
import com.hearttouch.entity.StudentInfoEntity;
import com.hearttouch.entity.User;
import com.hearttouch.service.DormRepairService;
import com.hearttouch.service.SchoolManageService;
import com.hearttouch.util.Const;
import com.hearttouch.util.GetPinyin;
import com.hearttouch.util.PageData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 总入口
 */
@Controller
public class DormRepairController extends BaseController {


    protected Logger logger = Logger.getLogger(this.getClass());
    @Resource(name = "schoolManageService")
    private SchoolManageService schoolManageService;

    @Resource(name = "dormRepairService")
    private DormRepairService dormRepairService;


    @RequestMapping(value = "/showIndex")
    public ModelAndView showIndex(Page page) throws Exception {
    	
        ModelAndView mv = this.getModelAndView();   
        mv.setViewName("school_index");
        try{
        PageData pd = new PageData();
        pd = this.getPageData();

    	HttpServletRequest request = this.getRequest();
    	HttpSession session = request.getSession();
    	//从服务器认证中获取信息
        String  openid = page.getPd().getString("openid");
        String nickname =   page.getPd().getString("nickname");
        String headimgurl = page.getPd().getString("headimgurl");
        String fromSite =pd.getString("fromSite");
        StudentInfoEntity studentInfoEntity =null;
       //从云生活中没有传来参数
        if((openid ==null || "".equals(openid))){
        	openid = pd.getString("openid");
        }
        if(nickname ==null || "".equals(nickname)){
        	nickname = pd.getString("nickname");
        }
        if(headimgurl ==null || "".equals(headimgurl)){
        	headimgurl = pd.getString("headimgurl");
        }	
        //来自的站点
        if((fromSite ==null || "".equals(fromSite))){
        	fromSite = pd.getString("fromSite");
        }
        //云生活中没有传来参数值走我们的认证页面
/*        if((openid ==null || "".equals(openid))&& (code ==null || "".equals(code))) {
        	 mv.setViewName("index");
           	//获取用户基本信息
    		String requestUrl=Const.SNSAPI_BASE_URL.replace("APPID",Const.APPID);
    		requestUrl =requestUrl.replace("REDIRECT_URI", Const.SNSAPI_BASE_REDIRECT_URI);
            mv.addObject("URL", requestUrl);
        	 return mv;
        } else */
/*      try{
	        
	        nickname =new String(nickname.getBytes("ISO-8859-1"),"UTF-8");
	      //  nickname =URLDecoder.decode(nickname,   "utf-8");   
	         headimgurl =new String(headimgurl.getBytes("ISO-8859-1"),"UTF-8");
         }catch(Exception ex) {
        	 
         }*/
        if(openid !=null ) {
        	pd.put("open_id", openid);
    		pd.put("nickname", nickname);
    		pd.put("headimgurl", headimgurl);		
        	pd.put("openid", openid);
        	studentInfoEntity = schoolManageService.listStudentInfobyOpen_id(openid);
        	if(!(studentInfoEntity !=null && studentInfoEntity.getOpen_id()!=null)){
	        	//把数据保存在服务器表中
	        	schoolManageService.addStudentInfo(pd);
        	}
        }
/*        try{
	        //从别的画面迁移过来时
	        if(openid ==null || "".equals(openid)){
	            
	          	//获取REFRESH_TOKEN 开始
	    		String requestUrl=Const.REFRESH_TOKEN_URL.replace("APPID",Const.APPID);
	    		requestUrl =requestUrl.replace("SECRET", Const.APP_SECRET);
	    		requestUrl=requestUrl.replace("CODE", code);
	    		JSONObject jsonObject = WeixinController.httpRequst(requestUrl, "GET", null);
	    		openid=jsonObject.getString("openid");
	        }
        }catch(Exception ex) {
        	logger.error(ex);
        }*/
     
		User user =new User();
        session.removeAttribute("user");
        user.setOpen_id(openid);
        //来自的站点
        user.setFromSite(fromSite);
        //用户信息查询不成功时候重新查询
        if(!(studentInfoEntity !=null && studentInfoEntity.getOpen_id()!=null)){
        	studentInfoEntity = schoolManageService.listStudentInfobyOpen_id(openid);      
        }
        //已保存信息的用户，获取用户信息
        if(studentInfoEntity !=null && studentInfoEntity.getOpen_id()!=null){
	        user.setSchool(studentInfoEntity.getSchool());
	        user.setSchool_name(studentInfoEntity.getSchool_name());
	        user.setNickname(studentInfoEntity.getNickname());
	        user.setHeadimgurl(studentInfoEntity.getHeadimgurl());
	        user.setTel(studentInfoEntity.getTel());
	        user.setName(studentInfoEntity.getName());
	        user.setId_card(studentInfoEntity.getId_card());
	       
	        
        } /*else {
        	// mv.setViewName("authority_Comfirm");
	       	 mv.setViewName("index");
	        	//获取用户基本信息
	 		String requestUrl=Const.SNSAPI_USERINFO_URL.replace("APPID",Const.APPID);
	 		requestUrl =requestUrl.replace("REDIRECT_URI", Const.SNSAPI_USERINFO_REDIRECT_URI);
	 		mv.addObject("URL", requestUrl);
	     	 return mv;
        }*/
        session.setAttribute("user", user);
	       if(Const.FROM_SITE_XINCD.equals(fromSite)){
	    	  // return new ModelAndView("redirect:/dormRepair");
	    	    mv.setViewName("accountInfo");
	        } 
        }catch(Exception ex) {
        	logger.error(ex);
        }
       
  
        //学校添加
        return mv;
    }

    //显示学生信息
    @RequestMapping(value = "/showStudent")
    public ModelAndView showStudent(Page page) throws Exception {
        ModelAndView mv = this.getModelAndView();   
        mv.setViewName("student");
        return mv;
    }
    
    //显示学生信息
    @RequestMapping(value = "/showStudentInfo")
    public ModelAndView showStudentInfo(Page page) throws Exception {
        ModelAndView mv = this.getModelAndView();   
        PageData pd = new PageData();
        pd = this.getPageData();
    	HttpServletRequest request = this.getRequest();
    	HttpSession session = request.getSession();
        User user= (User)session.getAttribute("user");       

        StudentInfoEntity studentInfoEntity =schoolManageService.listStudentInfobyOpen_id(user.getOpen_id());

        mv.addObject("studentInfo", studentInfoEntity);
        mv.setViewName("student_info");
        return mv;
    }
    //修改个人信息
    @RequestMapping(value = "/updateStudentDetailInfo")
    public void updateStudentDetailInfo(PrintWriter out) throws Exception {
        PageData pd = new PageData();
        pd = this.getPageData();
        String msg ="";
        // 取得学校
        int iCnt =schoolManageService.updateStudentDetailInfo(pd);
        if(iCnt >=1) {
             msg="{\"code\":100,\"msg\":\"个人信息修改成功\"}";
        } else {
        	 msg="{\"code\":200,\"msg\":\"个人信息修改失败\"}";
        }
//        System.out.println(jsonHistoryclickData);
        out.write(msg);
        out.close();
    }
    //显示学校列表
    @RequestMapping(value = "/showSchoolList")
    public ModelAndView showSchoolList(Page page) throws Exception {
    	
        ModelAndView mv = this.getModelAndView();   
        PageData pd = new PageData();
        pd = this.getPageData();
        Map<String,Object> mapSchool = new TreeMap<String,Object>();
        // 取得学校
        
        List<DormRepairEntity> listAreaA = dormRepairService.listAreaA(pd);
        for(DormRepairEntity dormRepairEntity : listAreaA) {
        	String area_a_name = dormRepairEntity.getArea_a_name();
        	String pinYinHeadChar = GetPinyin.getPinYinHeadChar(area_a_name);
        	if(pinYinHeadChar!=null && pinYinHeadChar.length() >0)
        	 pinYinHeadChar =pinYinHeadChar.toUpperCase().substring(0, 1);
        	if(mapSchool.get(pinYinHeadChar) ==null) {
        		 List<DormRepairEntity> listHeadCharAreaA = new  ArrayList<DormRepairEntity>();
        		 listHeadCharAreaA.add(dormRepairEntity);
        		 mapSchool.put(pinYinHeadChar, listHeadCharAreaA);
        	} else {
       		 List<DormRepairEntity> listHeadCharAreaA = (ArrayList<DormRepairEntity>)mapSchool.get(pinYinHeadChar);
       		 listHeadCharAreaA.add(dormRepairEntity);
       		 mapSchool.put(pinYinHeadChar, listHeadCharAreaA);
        	}
        	
        }
        if(listAreaA==null || listAreaA.size() ==0) {
        	 mapSchool.put("没有符合条件的数据！", new  ArrayList<DormRepairEntity>());
        }
        mv.addObject("page", page);
        page.setPd(pd);
        mv.addObject("mapSchool", mapSchool);
        mv.addObject("page", page);
        mv.addObject("pd", pd);
        
        mv.setViewName("school_list");


        //学校添加
        return mv;
    }
    @RequestMapping(value = "/addStudentInfo")
    public ModelAndView  AddStudentInfo(Page page) throws Exception
    {
        PageData pd = new PageData();
        pd = this.getPageData();
        String code =pd.getString("code");
        String openid= null;
        String nickname =null ;
        String headimgurl = null;
        try {
	      	//获取REFRESH_TOKEN 开始
			String requestUrl=Const.REFRESH_TOKEN_URL.replace("APPID",Const.APPID);
			requestUrl =requestUrl.replace("SECRET", Const.APP_SECRET);
			requestUrl=requestUrl.replace("CODE", code);
			JSONObject jsonObject = WeixinController.httpRequst(requestUrl, "GET", null);
			openid=jsonObject.getString("openid");
			String refresh_token = jsonObject.getString("refresh_token");
	    	//获取结束 开始
			requestUrl=Const.ACCESS_TOKEN_URL.replace("APPID",Const.APPID);
			requestUrl =requestUrl.replace("SECRET", Const.APP_SECRET);
			requestUrl=requestUrl.replace("REFRESH_TOKEN", refresh_token);
			jsonObject = WeixinController.httpRequst(requestUrl, "GET", null);
			String access_token=jsonObject.getString("access_token");
			requestUrl=Const.USER_INFO_URL.replace("ACCESS_TOKEN", access_token);
			requestUrl=requestUrl.replace("OPENID", openid);
			jsonObject = WeixinController.httpRequst(requestUrl, "GET", null);
			 headimgurl=jsonObject.getString("headimgurl");
			nickname=jsonObject.getString("nickname");
        }catch(Exception ex) {
        	logger.error(ex);
        }
		pd.put("open_id", openid);
		pd.put("nickname", nickname);
		pd.put("headimgurl", headimgurl);		
    	pd.put("openid", openid);
    	page.setPd(pd);
    	return showIndex(page);
    }
/*    @RequestMapping(value = "/showIndex")
    public ModelAndView showIndex(Page page) throws Exception {

        PageData pd = new PageData();
        pd = this.getPageData();
    	HttpServletRequest request = this.getRequest();
    	HttpSession session = request.getSession();
        String user_id =pd.getString("user_id");
        session.removeAttribute("school");
        session.setAttribute("school", "f39cb54b446e782d014476a0695f0217");
        session.setAttribute("school_name", "华中科技大学");
        ModelAndView mv = this.getModelAndView();
      
        mv.setViewName("index");
        //学校添加
        return mv;
    }*/

    
    @RequestMapping(value = "/schoolAdd")
    public ModelAndView schoolAdd(Page page) throws Exception {

        PageData pd = new PageData();
        pd = this.getPageData();
        String school = pd.getString("school");
        // 取得学校
        List<DormRepairEntity> listAreaA = dormRepairService.listAreaA(null);
        ModelAndView mv = this.getModelAndView();
        mv.addObject("listAreaA", listAreaA);
        mv.setViewName("school_add");
        //学校添加
        return mv;
    }
    @RequestMapping(value = "/dormRepair")
    public ModelAndView dormRepair(Page page) throws Exception {

    	   PageData pd = new PageData();
           pd = this.getPageData();
           String school = pd.getString("school");
           //已加入的用户取得栋号
           HttpServletRequest request = this.getRequest();
       	   HttpSession session = request.getSession();
           User user= (User)session.getAttribute("user");
           // 取得学校
           List<DormRepairEntity> listAreaA = dormRepairService.listAreaA(null);
 
           List<HashMap> listRepairTime = new ArrayList<HashMap>();
           List<HashMap> listRepairTimeDayAffterTomorrow= new ArrayList<HashMap>();

           for(int i=8;i<=20;i++){
        	   HashMap mapTomorrow = new HashMap();
        	   HashMap mapDayAffterTomorrow = new HashMap();
        	   String time ="";
        	   if(i<10){
        		   time="0"+i +":00:00";
        	   }else {
        		   time=i +":00:00";
        	   }
        	   mapTomorrow.put("repair_time", "次日"+time);
        	   mapDayAffterTomorrow.put("repair_time", "后天"+time);
        	   listRepairTime.add(mapTomorrow);
        	   listRepairTimeDayAffterTomorrow.add(mapDayAffterTomorrow);
        		   
           }
           listRepairTime.addAll(listRepairTimeDayAffterTomorrow);
           ModelAndView mv = this.getModelAndView();
           mv.addObject("listAreaA", listAreaA);
       
           mv.addObject("listRepairTime", listRepairTime);
           mv.setViewName("dorm_repair");
          

           List<DormRepairEntity> listAreaB = new ArrayList<DormRepairEntity>();
           if(user !=null && user.getSchool()!=null){
        	pd.put("area_a", user.getSchool());
             listAreaB = dormRepairService.listAreaB(pd);
           }
           mv.addObject("listAreaB", listAreaB);
           
           List<DormRepairEntity> listAreaAForUser = dormRepairService.listAreaA(pd);
           if(listAreaAForUser !=null && listAreaAForUser.size() >0){
        	   pd.put("create_dept", listAreaAForUser.get(0).getCreate_dept());
               // 取得报修类型
               List<DormRepairEntity> listClassA = dormRepairService.listClassA(pd);
               mv.addObject("listClassA", listClassA);
           }
           //学校添加
           return mv;
    }
    
    //报修类型
    @RequestMapping(value = "/showRepairClassA")
    public void showRepairClassA(PrintWriter out) throws Exception {
        PageData pd = new PageData();
        pd = this.getPageData();
        List<DormRepairEntity> listAreaA = dormRepairService.listAreaA(pd);
        if(listAreaA !=null && listAreaA.size() >0){
     	   pd.put("create_dept", listAreaA.get(0).getCreate_dept());
        }

        // 取得报修类型
        List<DormRepairEntity> listClassA = dormRepairService.listClassA(pd);

        JSONArray arrClassA = JSONArray.fromObject(listClassA);
        String jsonClassA = arrClassA.toString();
//        System.out.println(jsonHistoryclickData);
        out.write(jsonClassA);
        out.close();
    }
    //报修内容
    @RequestMapping(value = "/showRepairClassB")
    public void showRepairClassB(PrintWriter out) throws Exception {
        PageData pd = new PageData();
        pd = this.getPageData();
        String classA = pd.getString("classA");
        // 报修内容
        List<DormRepairEntity> listClassB = dormRepairService.listClassB(pd);

        JSONArray arrClassB = JSONArray.fromObject(listClassB);
        String jsonClassB = arrClassB.toString();
//        System.out.println(jsonHistoryclickData);
        out.write(jsonClassB);
        out.close();
    }
    //显示栋号
    @RequestMapping(value = "/showAreaB")
    public void showAreaB(PrintWriter out) throws Exception {
        PageData pd = new PageData();
        pd = this.getPageData();
        String areaA = pd.getString("areaA");
        // 取得栋号
        List<DormRepairEntity> listAreaB = dormRepairService.listAreaB(pd);

        JSONArray arrAreaB = JSONArray.fromObject(listAreaB);
        String jsonAreaB = arrAreaB.toString();
//        System.out.println(jsonHistoryclickData);
        out.write(jsonAreaB);
        out.close();
    }
    //显示楼层
    @RequestMapping(value = "/showAreaF")
    public void showAreaF(PrintWriter out) throws Exception {
        PageData pd = new PageData();
        pd = this.getPageData();
        String areaB = pd.getString("areaB");
        // 取得学校
        List<DormRepairEntity> listAreaF = dormRepairService.listAreaF(pd);

        JSONArray arrAreaF = JSONArray.fromObject(listAreaF);
        String jsonAreaF = arrAreaF.toString();
//        System.out.println(jsonHistoryclickData);
        out.write(jsonAreaF);
        out.close();
    }
    //显示寝室号
    @RequestMapping(value = "/showAreaR")
    public void showAreaR(PrintWriter out) throws Exception {
        PageData pd = new PageData();
        pd = this.getPageData();
        String areaF = pd.getString("areaF");
        // 取得学校
        List<DormRepairEntity> listAreaR = dormRepairService.listAreaR(pd);

        JSONArray arrAreaR = JSONArray.fromObject(listAreaR);
        String jsonAreaR = arrAreaR.toString();
//        System.out.println(jsonHistoryclickData);
        out.write(jsonAreaR);
        out.close();
    }
    @RequestMapping(value = "/addRepairInfo")
    public void addRepairInfo(Page page,PrintWriter out) throws Exception {
        PageData pd = new PageData();
        pd = this.getPageData();
        //生成key
        pd.put("id", get32UUID());
        String school = pd.getString("school");
        // 添加报修记录
        dormRepairService.addRepairInfo(pd);
        HttpServletRequest request = this.getRequest();
    	HttpSession session = request.getSession();
        User user= (User)session.getAttribute("user");
        pd.put("fault_id", pd.get("id"));
        if(user!=null){
        	pd.put("open_id", user.getOpen_id());
        }
        dormRepairService.addDormRepairHistory(pd);
        page.setPd(pd);
        pushMessage(page);
//        System.out.println(jsonHistoryclickData);
        String msg="{\"msg\":\"寝室保修提交成功\"}";
        out.write(msg);
        out.close();
    }
    //显示学生信息
    @RequestMapping(value = "/repairSuccess")
    public ModelAndView repairSuccess(Page page) throws Exception {
        ModelAndView mv = this.getModelAndView();   
        mv.setViewName("dorm_repair_sucess");
        return mv;
    }
    public void pushMessage(Page page) throws Exception{
    	
		try {
			PageData pd = new PageData();
			pd = this.getPageData();
           //已加入的用户取得栋号
           HttpServletRequest request = this.getRequest();
       	   HttpSession session = request.getSession();
           User user= (User)session.getAttribute("user");
           String fromSite= "";
           String name ="";
           //取得用户名如果用户没有填写真实姓名，填写昵称
           if(user!=null ){
        	   if(user.getName() !=null && !"".equals(user.getName())){
        	   name = user.getName();
        	   }
        	   else {
        		   name = user.getNickname();
        	   }
        	   fromSite =user.getFromSite();
           }
/*           user =new User();
           user.setOpen_id("oAULZwp8n1ZtBegw5Q1qkdFBP0W4");
           user.setName("yeah");*/
			// 获取access_token 开始
            String requestUrl="";
            if(Const.FROM_SITE_XINCD.equals(fromSite)){
				requestUrl = Const.DIRECT_ACCESS_TOKEN_URL.replace("APPID",
						Const.APPID_XINCD);
				requestUrl = requestUrl.replace("APPSECRET", Const.APP_SECRET_XINCD);	
            } else {
				requestUrl = Const.DIRECT_ACCESS_TOKEN_URL.replace("APPID",
						Const.APPID);
				requestUrl = requestUrl.replace("APPSECRET", Const.APP_SECRET);
            }
			JSONObject jsonObject = WeixinController.httpRequst(requestUrl,
					"GET", null);
			String access_token = jsonObject.getString("access_token");
			requestUrl = Const.POST_TEMPLETE_MESSAGE_URL.replace(
					"ACCESS_TOKEN", access_token);
			//设置消息内容
			MsgTemplate msgTemplate = new MsgTemplate();
			msgTemplate.setTouser(user.getOpen_id());
			//设置消息模板
			 if(Const.FROM_SITE_XINCD.equals(fromSite)){
				 msgTemplate.setTemplate_id(Const.MESSAGE_TEMPLATE_ID_XINCD);
			 } else {
				 msgTemplate.setTemplate_id(Const.MESSAGE_TEMPLATE_ID);
			 }
			msgTemplate.setTopcolor("#000000");
			msgTemplate.setUrl("");

     
			msgTemplate.addTextField("first", "");
			msgTemplate.addTextField("keyword1", name,"#000000");			
			
			// 报修类型
			String class_a_name = "";
			List<DormRepairEntity> listClassA = dormRepairService
					.listClassA(pd);
			if (listClassA != null && listClassA.size() > 0) {
				class_a_name = listClassA.get(0).getClass_a_name();
			}
			// 报修类型
			String class_b_name = "";
			List<DormRepairEntity> listClassB = dormRepairService
					.listClassB(pd);
			if (listClassB != null && listClassB.size() > 0) {
				class_b_name = listClassB.get(0).getClass_b_name();
			}
			msgTemplate.addTextField("keyword2", class_a_name , "#000000");
			msgTemplate.addTextField("keyword3", class_b_name, "#000000");
	         // 取得学校名字
			String area_a_name = "";
	         List<DormRepairEntity> listAreaA = dormRepairService.listAreaA(pd);
			if (listAreaA != null && listAreaA.size() > 0) {
				area_a_name = listAreaA.get(0).getArea_a_name();
			}
	         // 取得栋号
			String area_b_name = "";
	         List<DormRepairEntity> listAreaB = dormRepairService.listAreaB(pd);
			if (listAreaB != null && listAreaB.size() > 0) {
				area_b_name = listAreaB.get(0).getArea_b_name();
			}
	         // 取得楼层
			String area_f_name = "";
	         List<DormRepairEntity> listAreaF = dormRepairService.listAreaF(pd);
			if (listAreaF != null && listAreaF.size() > 0) {
				area_f_name = listAreaF.get(0).getArea_f_name();
			}
	         // 取得楼层
			String area_r_name = "";
	         List<DormRepairEntity> listAreaR = dormRepairService.listAreaR(pd);
			if (listAreaR != null && listAreaR.size() > 0) {
				area_r_name = listAreaR.get(0).getArea_r_name();
			}	
			msgTemplate.addTextField("keyword4",area_a_name + area_b_name+ area_f_name+area_r_name, "#000000");
			msgTemplate.addTextField("keyword5", pd.getString("repair_time"), "#000000");
			msgTemplate.addTextField("remark", Const.MESSAGE_REMARK, "#000000");
			System.out.println(msgTemplate.toJson());
			String post_message = msgTemplate.toJson();
			jsonObject = WeixinController.httpRequst(requestUrl, "POST",
					post_message);
			if(!"0".equals(jsonObject.getString("errcode"))) {
				logger.error("消息发送失败："+jsonObject.toString());
			}

		} catch (Exception ex) {
			logger.error(ex);
		}
    }
    @RequestMapping(value = "/showDormRepairHistory")
    public ModelAndView showDormRepairHistory(Page page) throws Exception {

    	   PageData pd = new PageData();
           pd = this.getPageData();
           ModelAndView mv = this.getModelAndView();   
           mv.setViewName("repair_history");
           //已加入的用户取得栋号
           HttpServletRequest request = this.getRequest();
       	   HttpSession session = request.getSession();
           User user= (User)session.getAttribute("user");
           pd.put("open_id", user.getOpen_id());
           // 报修历史记录报修ID
           List<DormRepairEntity> listDormRepairHistory = dormRepairService.listDormRepairHistory(pd);
           List<String> repairIds = new ArrayList<String>();
           
           for(DormRepairEntity dormRepairEntity:listDormRepairHistory){
        	   repairIds.add(dormRepairEntity.getFault_id());
           }
           pd.put("repairIds", repairIds);
           // 报修历史记录
           List<DormRepairEntity> listDormRepairHistoryInfo =  new ArrayList<DormRepairEntity>();
           if(repairIds.size() >0){
        	   listDormRepairHistoryInfo = dormRepairService.listDormRepairHistoryInfo(pd);
           }
           int index=0;
           for(DormRepairEntity dormRepairEntity:listDormRepairHistoryInfo){
        	   dormRepairEntity.setStat(DormRepairEntity.statMap.get(dormRepairEntity.getStat()));
        	   listDormRepairHistoryInfo.set(index, dormRepairEntity);
        	   index++;
           }
           mv.addObject("listDormRepairHistoryInfo", listDormRepairHistoryInfo);
           //学校添加
           return mv;
    }
    
}
