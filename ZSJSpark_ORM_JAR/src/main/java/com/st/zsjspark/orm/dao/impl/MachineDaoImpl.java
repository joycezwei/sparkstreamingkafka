package com.st.zsjspark.orm.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.st.zsjspark.model.Machine;
import com.st.zsjspark.orm.dao.IMachineDao;
import com.st.zsjspark.orm.dao.base.impl.BaseDaoImpl;

/**
 * Machine Dao接口的实现
 * 
 * @author Alex
 * @since 2016.10.22
 * 
 */
@Repository
public class MachineDaoImpl extends BaseDaoImpl<Machine> implements IMachineDao {

	/**
	 * 调用FactoryDaoImpl实现类时，设置命名空间 设置命名空间
	 */
	public MachineDaoImpl() {
		super.setNameSpace("com.st.zsjspark.mapper.MachineMapper");
	}

	public Map getMachineStatus() {
		return this.getSqlSession().selectOne(getNameSpace()+".getStatus");
	}
	
	public List<Machine> findByMachine(Map condition){
		return this.getSqlSession().selectList(getNameSpace()+".findByMachine",condition);
	}

	@Override
	public List<Machine> findByStatus(Map condition) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(getNameSpace()+".findByStatus",condition);
	}
	@Override
	public List<Machine> findMachine(Map condition) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(getNameSpace()+".findMachine",condition);
	}
}
