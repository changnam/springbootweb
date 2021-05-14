package com.honsoft.web.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.honsoft.web.filter.MyFilter;
import com.honsoft.web.servlet.MyServlet;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	 @Override
	    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		 configurer.favorParameter(true).
		   ignoreAcceptHeader(false).
		   defaultContentType(MediaType.APPLICATION_JSON).
		   mediaType("xml", MediaType.APPLICATION_XML).
		   mediaType("json", MediaType.APPLICATION_JSON);
	    }
	 
	 @Bean
	 public CommonsRequestLoggingFilter requestLoggingFilter() {
	     CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	     loggingFilter.setIncludeClientInfo(true);
	     loggingFilter.setIncludeQueryString(true);
	     loggingFilter.setIncludePayload(true);
	     loggingFilter.setMaxPayloadLength(64000);
	     return loggingFilter;
	 }


	 @Bean
	 public MyFilter myServletFilter() {
		 MyFilter myFilter = new MyFilter();
	     return myFilter;
	 }

		// Register Servlet
	  @Bean
	  public ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean bean = new ServletRegistrationBean(
	        new MyServlet(), "/myServlet");
	    return bean;
	  }
	  
}