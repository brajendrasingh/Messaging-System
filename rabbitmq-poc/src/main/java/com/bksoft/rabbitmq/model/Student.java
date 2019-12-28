package com.bksoft.rabbitmq.model;

public class Student {

	private String name;
	private String rollNo;

	public Student() {
	}

	public Student(String name, String rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "Student [Name=" + name + ", rollNo=" + rollNo + "]";
	}

}
