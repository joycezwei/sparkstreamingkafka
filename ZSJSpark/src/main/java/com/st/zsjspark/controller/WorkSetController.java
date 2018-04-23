package com.st.zsjspark.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.zsjspark.comn.util.Tools;
import com.st.zsjspark.model.Workset;
import com.st.zsjspark.service.IWorkSetService;

/**
 * 工作告警WorkWarning的Controller层
 * 
 * @author weijian
 * @date Oct 24, 2016
 */
@Controller
@RequestMapping("/WorkSetController")
public class WorkSetController {

	@Resource
	private IWorkSetService workSetService;

	@RequestMapping(value = "/conditionSearch.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findbyCondition(Workset record) {
		Map map = Tools.transBean2Map(record);
		List<Workset> list = workSetService.findByCondition(map);
		JSONObject workWarnings = new JSONObject();
		workWarnings.put("data", list);
		return workWarnings.getString("data");
	}
	
	@RequestMapping(value = "/setWorkSet.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String save(Workset record,String data) {
		Map map = Tools.transBean2Map(record);
		workSetService.setWorkSet(map,data);
		JSONObject json = new JSONObject();
		json.put("error_code", 200);
		return json.toString();
	}
}