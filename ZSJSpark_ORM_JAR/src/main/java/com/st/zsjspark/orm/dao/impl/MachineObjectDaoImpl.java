package com.st.zsjspark.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.zsjspark.model.MachineObject;
import com.st.zsjspark.orm.dao.IMachineObjectDao;
import com.st.zsjspark.orm.dao.base.impl.BaseDaoImpl;

/**
 * FactoryDaoImpl
 * 注解开发
 * @author ZY
 */
@Repository
public class MachineObjectDaoImpl extends BaseDaoImpl<MachineObject> implements IMachineObjectDao{

	/**
	 * 调用FactoryDaoImpl实现类时，设置命名空间
	 * 设置命名空间
	 */
	public MachineObjectDaoImpl(){
		super.setNameSpace("com.st.zsjspark.mapper.MachineObjectMapper");
	}

}
