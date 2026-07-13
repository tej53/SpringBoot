package com.tej.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		Student student = new Student("pavan", 21);
		System.out.println("Name: " + student.getName());
		System.out.println("Age: " + student.getAge());
	}
}
