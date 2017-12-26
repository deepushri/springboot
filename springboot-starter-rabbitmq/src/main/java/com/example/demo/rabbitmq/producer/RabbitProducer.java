package com.example.demo.rabbitmq.producer;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {
	@Autowired 
	RabbitTemplate template;
	
	@Autowired
	Queue publishQueue;
	
	@Autowired 
	DirectExchange exchange;
	
	public void send(String message)
	{
		template.convertAndSend(exchange.getName(), publishQueue.getName(),message);
	}
}
