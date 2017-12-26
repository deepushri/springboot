package com.example.demo.rabbitmq.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
@Configuration

public class RabbitmqConfigurations {

	String publishqueue;
	String publishexchange;
	
	
	
	public String getPublishqueue() {
		return publishqueue;
	}

	public void setPublishqueue(String publishqueue) {
		this.publishqueue = publishqueue;
	}

	public String getPublishexchange() {
		return publishexchange;
	}

	public void setPublishexchange(String publishexchange) {
		this.publishexchange = publishexchange;
	}

	@Bean
	public Queue publishqueue()
	{
		return QueueBuilder.durable(publishqueue).build();
	}
	
	@Bean
	public DirectExchange exchange()
	{
		return new DirectExchange(publishexchange);
	}
	
	@Bean
	public Binding publishBinding(DirectExchange exchange, Queue publishqueue)
	{
		return BindingBuilder.bind(publishqueue).to(exchange).with(publishqueue.getName());
	}
	
	@Autowired
	public ConnectionFactory connection;
	
	@Autowired
	public AmqpAdmin admin;
}
