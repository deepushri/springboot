package com.example.demo.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rabbitmq.producer.RabbitProducer;

@RestController
public class MyRabbitmqController {

	@Autowired
	RabbitProducer producer;
	
	@GetMapping("/publishmessage")
	public String publishmessage()
	{
		producer.send("hello world");
		return "sent message successfully";
	}
}
