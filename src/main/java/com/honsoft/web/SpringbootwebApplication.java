package com.honsoft.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootwebApplication {
	
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringbootwebApplication.class, args);
		
		
		displayAllBeans();
	}

	public static void displayAllBeans() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		System.out.println("====================================================================");
		System.out.println("================ number of beans : "+ allBeanNames.length);
		System.out.println("====================================================================");
		
		for (String beanName : allBeanNames) {
			System.out.println(beanName);
		}
		
		System.out.println("====================================================================");
	}
}
