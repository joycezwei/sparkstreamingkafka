package com.st.zsjspark.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.zsjspark.comn.util.Tools;
import com.st.zsjspark.model.Workshop;
import com.st.zsjspark.service.IWorkshopService;

@Controller
@RequestMapping("/WorkshopController")
public class WorkshopController {
	
	@Resource
	private IWorkshopService workshopService;
	
	@RequestMapping(value = "/addNew.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public  String insertNewRecord(Workshop record){
		record.setStatus(1);
		workshopService.insert(record);
		JSONObject json = new JSONObject();
		json.put("error_code", 200);
		return json.toString();
	}
	
	@RequestMapping(value = "/update.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateRecord(Workshop record){
	    workshopService.update(record);
	    JSONObject json = new JSONObject();
		json.put("error_code", 200);
		return json.toString();
	}
	
	@RequestMapping(value = "/getbyId.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getRecordbyId(int id){
	
		Workshop record = workshopService.findById(id);
		JSONObject json = new JSONObject();
		json.put("data", record);
		json.put("error_code", 200);
		return json.toString();
	}
	
	@RequestMapping(value = "/delete.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteRecord(Workshop record){
		workshopService.update(record);
	    JSONObject json = new JSONObject();
		json.put("error_code", 200);
		return json.toString();
	}
	@RequestMapping(value = "/conditionSearch.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findbyCondition(Workshop record){
		Map map = Tools.transBean2Map(record);
		List<Workshop> list = workshopService.findByCondition(map);
	    JSONObject json = new JSONObject();
	    json.put("data", list);
//	    json.put("rows", list);
//	    json.put("total", 15);
		return json.getString("data");
//		return json.toString();
	}
}
