package com.tej.demo;

import com.tej.demo.DependencyInjection.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
//		Student student = new Student("pavan", 21);
//		System.out.println("Name: " + student.getName());
//		System.out.println("Age: " + student.getAge());
		ApplicationContext context = SpringApplication.run(DemoApplication.class);
//		Student student = context.getBean(Student.class);
//		student.setName("Pavan");
//		student.setAge(21);
//
//		System.out.println("Name: " + student.getName());
//		System.out.println("Age: " + student.getAge());

		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
	}
}
