package com.st.zsjspark.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * kafka监听器启动 自动监听是否有消息需要消费
 * 
 * @author wangb
 * 
 */
public class KafkaConsumerServiceImpl implements
		MessageListener<String, String> {

	public Map<String, String> coordinationCache = new HashMap<String, String>();

	private Logger logger = LoggerFactory.getLogger("kafkaConsumer");


	/**
	 * 监听器自动执行该方法 消费消息 自动提交offset 执行业务代码 （high level api
	 * 不提供offset管理，不能指定offset进行消费）
	 */
	@Override
	public void onMessage(ConsumerRecord<String, String> record) {
		String topic = record.topic();
		// ReData_MachineRealTime
		String value = record.value();
		logger.info(value);
		switch (topic) {
		case "ReData_MachineReal":
			coordinationCache.put("ReData_MachineReal", value);
			break;
		case "ReData_Connections":
			coordinationCache.put("ReData_Connections", value);
			break;
		case "ReData_Pattern":
			coordinationCache.put("ReData_Pattern", value);
			break;
		case "ReData_WorkTime":
			coordinationCache.put("ReData_WorkTime", value);
			break;
		case "ReData_Warning":
			coordinationCache.put("ReData_Warning", value);
			break;
		}
	}

}