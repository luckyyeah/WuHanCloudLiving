package com.hearttouch.controllers;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hearttouch.controllers.base.BaseController;
import com.hearttouch.entity.Page;
import com.hearttouch.entity.StudentInfoEntity;
import com.hearttouch.entity.User;
import com.hearttouch.service.SchoolManageService;
import com.hearttouch.util.PageData;

/*
 * 总入口
 */
@Controller
public class SchoolManageController extends BaseController {


    protected Logger logger = Logger.getLogger(this.getClass());
    @Resource(name = "schoolManageService")
    private SchoolManageService schoolManageService;

    @RequestMapping(value = "/updateStudentInfo")
    public void addStudentInfo(Page page,PrintWriter out) throws Exception {
    	 String msg ="";
        PageData pd = new PageData();
        pd = this.getPageData();
        String open_id =pd.getString("open_id");
        StudentInfoEntity schoolInfoEntity =schoolManageService.listStudentInfobyOpen_id(open_id);
        schoolManageService.updateStudentInfo(pd);
        if(schoolInfoEntity !=null && schoolInfoEntity.getSchool()!=null){        	
        	  msg="{\"msg\":\"学校变更成功\"}";
        } else {
	        // 添加学校信息
	         msg="{\"msg\":\"学校添加成功\"}";
        }
    	HttpServletRequest request = this.getRequest();
    	HttpSession session = request.getSession();
		//进入时取得用户信息
        schoolInfoEntity =schoolManageService.listStudentInfobyOpen_id(open_id);
        User user= (User)session.getAttribute("user");
        if(schoolInfoEntity !=null && schoolInfoEntity.getSchool()!=null){
	        user.setSchool(schoolInfoEntity.getSchool());
	        user.setSchool_name(schoolInfoEntity.getSchool_name());
        }
        session.setAttribute("user", user);
        out.write(msg);
        out.close();
    }
}
