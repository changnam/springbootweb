package com.honsoft.web;

import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.honsoft.web.filter.MyFilter;
import com.honsoft.web.listener.AppContextListener;
import com.honsoft.web.servlet.MyServlet;

@SpringBootApplication
@ServletComponentScan 
public class SpringbootwebApplication {
	
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringbootwebApplication.class, args);
		
		
		//displayAllBeans();
	}

	public static void displayAllBeans() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		System.out.println("====================================================================");
		System.out.println("================ number of beans : "+ allBeanNames.length);
		System.out.println("====================================================================");
		
		for (String beanName : allBeanNames) {
			System.out.println(beanName+ " : " + applicationContext.getBean(beanName).getClass().toString());
		}
		
		System.out.println("====================================================================");
	}
	
	// Register Servlet
	  @Bean
	  public ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean bean = new ServletRegistrationBean(
	        new MyServlet(), "/myServlet");
	    return bean;
	  }

	  // Register Filter
	  @Bean
	  public FilterRegistrationBean filterRegistrationBean() {
	    FilterRegistrationBean bean = new FilterRegistrationBean(new MyFilter());
	    // Mapping filter to a Servlet
	    bean.addServletRegistrationBeans(new ServletRegistrationBean[] {
	          servletRegistrationBean() 
	       });
	    return bean;
	  }

	  // Register ServletContextListener
	  // Listener 들은 @WebListener 어노테이션을 이용해서 등록해야 한다.
	  
}
