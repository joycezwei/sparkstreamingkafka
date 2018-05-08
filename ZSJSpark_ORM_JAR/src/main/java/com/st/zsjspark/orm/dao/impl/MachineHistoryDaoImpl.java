package com.st.zsjspark.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.zsjspark.model.MachineHistory;
import com.st.zsjspark.orm.dao.IMachineHistoryDao;
import com.st.zsjspark.orm.dao.base.impl.BaseDaoImpl;

/**
 * FactoryDaoImpl
 * 注解开发
 * @author wlq
 */
@Repository
public class MachineHistoryDaoImpl extends BaseDaoImpl<MachineHistory> implements IMachineHistoryDao{

	/**
	 * 调用FactoryDaoImpl实现类时，设置命名空间
	 * 设置命名空间
	 */
	public MachineHistoryDaoImpl(){
		super.setNameSpace("com.st.zsjspark.mapper.MachineHistoryMapper");
	}
}
