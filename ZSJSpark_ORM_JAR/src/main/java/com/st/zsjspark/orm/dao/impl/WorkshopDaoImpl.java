package com.st.zsjspark.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.zsjspark.model.Workshop;
import com.st.zsjspark.orm.dao.IWorkshopDao;
import com.st.zsjspark.orm.dao.base.impl.BaseDaoImpl;

/**
 * FactoryDaoImpl
 * 注解开发
 * @author wlq
 */
@Repository
public class WorkshopDaoImpl extends BaseDaoImpl<Workshop> implements IWorkshopDao{

	/**
	 * 调用FactoryDaoImpl实现类时，设置命名空间
	 * 设置命名空间
	 */
	public WorkshopDaoImpl(){
		super.setNameSpace("com.st.zsjspark.mapper.WorkshopMapper");
	}

}
