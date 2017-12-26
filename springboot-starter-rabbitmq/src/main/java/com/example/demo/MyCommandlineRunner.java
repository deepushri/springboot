package com.example.demo;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandlineRunner implements CommandLineRunner {

	@Autowired 
	RabbitTemplate template;
	
	@Autowired
	Queue publishQueue;
	
	@Autowired 
	DirectExchange exchange;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		template.convertAndSend(exchange.getName(), publishQueue.getName(),"Hello world");

	}

}
