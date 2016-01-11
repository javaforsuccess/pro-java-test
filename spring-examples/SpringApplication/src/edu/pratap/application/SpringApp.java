package edu.pratap.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) 
	{
		ApplicationContext container=new ClassPathXmlApplicationContext("spring-container.xml");
		Triangle triangle=(Triangle) container.getBean("triangle");
		triangle.showDetails();
	}

}
