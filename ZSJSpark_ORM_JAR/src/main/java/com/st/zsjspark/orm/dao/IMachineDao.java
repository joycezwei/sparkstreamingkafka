package com.st.zsjspark.orm.dao;

import java.util.List;
import java.util.Map;

import com.st.zsjspark.model.Machine;
import com.st.zsjspark.orm.dao.base.IBaseDao;

/**
 * Machine Dao接口
 * 
 * @author Alex
 * @since 2016.10.22
 * 
 */
public interface IMachineDao extends IBaseDao<Machine>{
	public Map getMachineStatus();
	List<Machine> findByMachine(Map condition);
	List<Machine> findByStatus(Map condition);
	public List<Machine> findMachine(Map condition);
}
