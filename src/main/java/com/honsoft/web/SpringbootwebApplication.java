package com.honsoft.web;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class SpringbootwebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();

			System.out.println("====================================================================");
			System.out.println("================ number of beans : " + beanNames.length);
			System.out.println("====================================================================");

			Arrays.sort(beanNames);

			for (String beanName : beanNames) {
				System.out.println(beanName + " : " + ctx.getBean(beanName).getClass().toString());
			}

			System.out.println("====================================================================");

		};
	}

}
