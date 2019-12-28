package com.bksoft.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.bksoft.rabbitmq.model.Student;

@Component
public class StudentListener {

	@RabbitListener(queues = "${app.rabbitmq.queue}")
	public void saveStudent(Student s) {
		
		System.out.println(s);
	}
}
