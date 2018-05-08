package com.st.zsjspark.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.zsjspark.model.MachineGroup;
import com.st.zsjspark.orm.dao.IMachineGroupDao;
import com.st.zsjspark.orm.dao.base.impl.BaseDaoImpl;
/**
 * FactoryDaoImpl
 * 注解开发
 * @author zjm
 */
@Repository
public class MachineGroupDaoImpl extends BaseDaoImpl<MachineGroup> implements IMachineGroupDao{
	/**
	 * 调用FactoryDaoImpl实现类时，设置命名空间
	 * 设置命名空间
	 */
	public MachineGroupDaoImpl(){
		super.setNameSpace("com.st.zsjspark.mapper.MachineGroupMapper");
	}
}
