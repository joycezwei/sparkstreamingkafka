package com.st.zsjspark.service;


public interface IKafkaProducerService{
	public void sendMessage(String topic, String data);
	public void sendMessage(String topic, int key, String data);
}
