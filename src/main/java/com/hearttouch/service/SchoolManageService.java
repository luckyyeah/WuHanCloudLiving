package com.hearttouch.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hearttouch.dao.DaoSupport;

import com.hearttouch.entity.Page;
import com.hearttouch.entity.StudentInfoEntity;
import com.hearttouch.util.PageData;



@Service("schoolManageService")
public class SchoolManageService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	

	//======================================================================================

	public StudentInfoEntity listStudentInfobyOpen_id(String open_id)throws Exception{
		return (StudentInfoEntity) dao.findForObject("SchoolManageMapper.listStudentInfobyOpen_id", open_id);
	}

	
	public void addStudentInfo(PageData pd)throws Exception{
		  dao.findForList("SchoolManageMapper.addStudentInfo", pd);
	}
	public void updateStudentInfo(PageData pd)throws Exception{
		  dao.findForList("SchoolManageMapper.updateStudentInfo", pd);
	}

	public int  updateStudentDetailInfo(PageData pd)throws Exception{
		return (int) dao.update("SchoolManageMapper.updateStudentDetailInfo", pd);
	}
}
