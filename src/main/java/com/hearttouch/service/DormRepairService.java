package com.hearttouch.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hearttouch.dao.DaoSupport;
import com.hearttouch.entity.DormRepairEntity;
import com.hearttouch.entity.Page;
import com.hearttouch.entity.StudentInfoEntity;
import com.hearttouch.util.PageData;



@Service("dormRepairService")
public class DormRepairService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	

	//======================================================================================

	public List<DormRepairEntity> listClassA(PageData pd)throws Exception{
		return (List<DormRepairEntity>) dao.findForList("DormRepairMapper.listClassA", pd);
	}
	

	//======================================================================================

	public List<DormRepairEntity> listClassB(PageData pd)throws Exception{
		return (List<DormRepairEntity>) dao.findForList("DormRepairMapper.listClassB", pd);
	}
	

	public List<DormRepairEntity> listAreaA(PageData pd)throws Exception{
		return (List<DormRepairEntity>) dao.findForList("DormRepairMapper.listAreaA", pd);
	}
	public List<DormRepairEntity> listAreaB(PageData pd)throws Exception{
		return (List<DormRepairEntity>) dao.findForList("DormRepairMapper.listAreaB", pd);
	}
	public List<DormRepairEntity> listAreaF(PageData pd)throws Exception{
		return (List<DormRepairEntity>) dao.findForList("DormRepairMapper.listAreaF", pd);
	}
	public List<DormRepairEntity> listAreaR(PageData pd)throws Exception{
		return (List<DormRepairEntity>) dao.findForList("DormRepairMapper.listAreaR", pd);
	}
	public void addRepairInfo(PageData pd)throws Exception{
		  dao.findForList("DormRepairMapper.addRepairInfo", pd);
	}

}
