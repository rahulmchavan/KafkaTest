package com.rc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.rc.model.Employee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProducerService {
 
	@Autowired
	private  KafkaTemplate kafkaTemplate;
	
	@Value("${kafka.topic.name}")
	private String topicName;

	public void sendMessage(String msg) {
		kafkaTemplate.send(topicName ,msg);
	}

	public void sendEmpInfo(Employee emp) {
		kafkaTemplate.send(topicName,emp);
		
	}

}
