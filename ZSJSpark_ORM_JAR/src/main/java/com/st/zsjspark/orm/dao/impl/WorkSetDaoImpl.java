package com.st.zsjspark.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.zsjspark.model.Workset;
import com.st.zsjspark.orm.dao.IWorkSetDao;
import com.st.zsjspark.orm.dao.base.impl.BaseDaoImpl;

/**
 * FactoryDaoImpl
 * 注解开发
 * @author wlq
 */
@Repository
public class WorkSetDaoImpl extends BaseDaoImpl<Workset> implements IWorkSetDao{

	/**
	 * 调用FactoryDaoImpl实现类时，设置命名空间
	 * 设置命名空间
	 */
	public WorkSetDaoImpl(){
		super.setNameSpace("com.st.zsjspark.mapper.WorksetMapper");
	}
}
