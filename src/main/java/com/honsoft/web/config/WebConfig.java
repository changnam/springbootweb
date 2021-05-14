package com.honsoft.web.config;

<<<<<<< HEAD
import org.springframework.boot.web.servlet.FilterRegistrationBean;
=======
>>>>>>> 596057ef64ea2ede3cde09e86305d28d50fd78c8
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
<<<<<<< HEAD
	 public FilterRegistrationBean requestLoggingFilter() {
=======
	 public CommonsRequestLoggingFilter requestLoggingFilter() {
>>>>>>> 596057ef64ea2ede3cde09e86305d28d50fd78c8
	     CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	     loggingFilter.setIncludeClientInfo(true);
	     loggingFilter.setIncludeQueryString(true);
	     loggingFilter.setIncludePayload(true);
	     loggingFilter.setMaxPayloadLength(64000);
<<<<<<< HEAD
	     
	     FilterRegistrationBean filter = new FilterRegistrationBean(loggingFilter);
	     filter.addUrlPatterns("/*");
	     filter.setOrder(3); //application.properties 에 security.filter-order=5 로 셋팅할것.
	     return filter;
	 }
	  

	// Register Filter
		  @Bean
		  public FilterRegistrationBean myFilter() {
		    FilterRegistrationBean filter = new FilterRegistrationBean(new MyFilter());
		    filter.addUrlPatterns("/myFilter");
		    // Mapping filter to a Servlet
		    //bean.addServletRegistrationBeans(new ServletRegistrationBean[] {
		    //      servletRegistrationBean() 
		     //  });
		    return filter;
		  }
	  
		// Register Servlet
	  @Bean
	  public ServletRegistrationBean myServlet() {
	    ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet());
	    bean.addUrlMappings("/myServlet");
=======
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
>>>>>>> 596057ef64ea2ede3cde09e86305d28d50fd78c8
	    return bean;
	  }
	  
}