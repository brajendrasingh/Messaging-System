package com.bksoft.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bksoft.rabbitmq.model.Student;

@Component
public class StudentSender {

	@Value("${app.rabbitmq.exchange}")
	String exchange;

	@Value("${app.rabbitmq.routingkey}")
	private String routingkey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendStudentDetails(Student s) {
		rabbitTemplate.convertAndSend(exchange, routingkey, s);
	}
}
