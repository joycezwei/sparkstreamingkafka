package com.st.zsjspark.service;

import java.util.Map;

import com.st.zsjspark.model.Machine;
import com.st.zsjspark.orm.dao.IWorkSetDao;

/**
 * IWorksetService接口
 * 
 * @author wlq
 * 
 */
public interface IWorkSetService extends IWorkSetDao{
	public void setWorkSet(Map map,String data); 
	public void addMachine(Map map,Machine machine);
}
