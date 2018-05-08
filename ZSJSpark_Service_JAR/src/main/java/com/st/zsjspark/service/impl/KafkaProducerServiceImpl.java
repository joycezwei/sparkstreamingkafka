package com.st.zsjspark.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.st.zsjspark.service.IKafkaProducerService;
  
  
public class KafkaProducerServiceImpl implements IKafkaProducerService {  
    private Logger logger = LoggerFactory.getLogger("kafka");  
  
    @Autowired  
    private KafkaTemplate<Integer, String> kafkaTemplate;//这个已经在上述xml文件中配置  
  
    @Override  
    public void sendMessage(String topic, String data) {  
        logger.info("the message is to be send by kafka is : topic = {}, data = {}", topic, data);  
        kafkaTemplate.setDefaultTopic(topic);  
        kafkaTemplate.sendDefault(data);  
    }  
  
    @Override  
    public void sendMessage(String topic, int key, String data) {  
        logger.info("the message is to be send by kafka is : topic = {}, data = {}", topic, data);  
        kafkaTemplate.setDefaultTopic(topic);  
        kafkaTemplate.sendDefault(key, data);  
    }  
}  
