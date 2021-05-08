package com.honsoft.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.honsoft.web.filter.MyFilter;
import com.honsoft.web.service.QuickGuideUserDetailsService;


@Configuration
@EnableWebSecurity (debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private QuickGuideUserDetailsService quickGuideUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/index").permitAll().antMatchers("/user/**").hasRole("USER")
				.and().formLogin().loginPage("/login").permitAll().failureUrl("/login-error").and().csrf().disable();
		
		http.httpBasic();
		
		http.addFilterAfter(new MyFilter(),UsernamePasswordAuthenticationFilter.class);
		
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
	        auth.userDetailsService(quickGuideUserDetailsService);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}