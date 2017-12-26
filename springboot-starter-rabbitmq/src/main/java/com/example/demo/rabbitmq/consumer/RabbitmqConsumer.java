package com.example.demo.rabbitmq.consumer;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="publishqueue")

public class RabbitmqConsumer {

	@Autowired 
	RabbitTemplate template;
	
    @RabbitHandler()
	public void receiveMessages(@Payload String message)
	{
    	System.out.println("=====================");
    	System.out.println("from string method");
		System.out.println(new String(message));
		System.out.println("=======================");
		
	}
    
    @RabbitHandler()
    public void receivebytearray(@Payload byte[] message,@Headers Map<String,Object>amqpheaders)
    {
    		System.out.println("byte array found");
    		System.out.println(new String(message));
    		
    		System.out.println(amqpheaders);
    }
    @RabbitHandler()
    public void receiveLong(@Payload long[] message)
    
    {
    	System.out.println("from long method");
    	
    }
    

}
