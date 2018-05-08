package com.st.zsjspark.service.impl;

import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.st.zsjspark.model.Machine;
import com.st.zsjspark.model.Workset;
import com.st.zsjspark.orm.dao.impl.WorkSetDaoImpl;
import com.st.zsjspark.service.IWorkSetService;

/**
 * WorksetServiceImpl 注解形式
 * 
 * @author wlq
 */
@Service
public class WorkSetServiceImpl extends WorkSetDaoImpl implements IWorkSetService {

	@Override
	public void setWorkSet(Map map, String data) {
		Workset workset = super.findByCondition(map).get(0);
		JSONObject jo = new JSONObject();
		jo.put("shebei", data);
		workset.setContext(jo.toString());
		super.update(workset);
	}
	
	@Override
	public void addMachine(Map map,Machine machine) {
		String data = "";
		Workset workset = super.findByCondition(map).get(0);
		JSONObject jo = new JSONObject();
		jo.put("shebei", data);
		workset.setContext(jo.toString());
		super.update(workset);
	}
}
