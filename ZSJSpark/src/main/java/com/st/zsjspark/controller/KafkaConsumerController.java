package com.st.zsjspark.controller;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.zsjspark.comn.util.StringUtils;
import com.st.zsjspark.service.impl.KafkaConsumerServiceImpl;

/**
 * kafka监听器启动 自动监听是否有消息需要消费
 * 
 * @author wangb
 * 
 */
@Controller
@RequestMapping("/KafkaConsumerController")
public class KafkaConsumerController {

	@Resource
	private KafkaConsumerServiceImpl kafkaConsumerService;

	@RequestMapping(value = "/conditionSearch.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findbyCondition() {
		JSONObject json = new JSONObject();
		String machineRealTime = null;
		machineRealTime = kafkaConsumerService.coordinationCache
				.get("ReData_MachineReal");
		json.put("data", machineRealTime);
		if (machineRealTime == null) {
			return null;
		} else {
			return json.getString("data");
		}
	}

	@RequestMapping(value = "/getMachineStatus.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getMachineStatus() {
		JSONObject json = new JSONObject();
		String machineRealTime = null;
		machineRealTime = kafkaConsumerService.coordinationCache
				.get("ReData_Connections");
		json.put("data", machineRealTime);
		if (machineRealTime == null) {
			return null;
		} else {
			return json.getString("data");
		}
	}

	@RequestMapping(value = "/findMDetial.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findDayDetial() {
		JSONObject json = new JSONObject();
		String machineRealTime = null;
		machineRealTime = kafkaConsumerService.coordinationCache
				.get("ReData_Pattern");
		String machineWarning = null;
		machineWarning = kafkaConsumerService.coordinationCache
				.get("ReData_Warning");
		if (StringUtils.isNULL(machineRealTime)) {
			machineRealTime = "{\"time0\":0,\"time1\":0,\"time2\":0,\"time3\":0,\"womnum\":0,\"omnum\":0}";
		}
		if (StringUtils.isNULL(machineWarning)) {
			machineRealTime = machineRealTime.replace('}', ',');
			machineRealTime = machineRealTime
					+ "\"warningnum\":0,\"wwarningnum\":0}";
			json.put("data", machineRealTime);
		} else {
			machineRealTime = machineRealTime.replace('}', ',');
			machineWarning = machineWarning.replace('{', ' ');
			json.put("data", machineRealTime + machineWarning);
		}
		return json.getString("data");
	}

	@RequestMapping(value = "/machineDay.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String machineDay() {
		JSONObject json = new JSONObject();
		String machineRealTime = null;
		machineRealTime = kafkaConsumerService.coordinationCache
				.get("ReData_WorkTime");
		json.put("data", machineRealTime);
		if (machineRealTime == null) {
			return null;
		} else {
			return json.getString("data");
		}
	}
}