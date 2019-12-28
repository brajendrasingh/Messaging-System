package com.bksoft.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bksoft.rabbitmq.model.Student;
import com.bksoft.rabbitmq.producer.StudentSender;

@RestController
public class RabbitTestingController {

	@Autowired
	private StudentSender sender;

	@RequestMapping(value = "/send")
	public String postStdent(@RequestBody Student student) {
		sender.sendStudentDetails(student);
		return "success";
	}
}
