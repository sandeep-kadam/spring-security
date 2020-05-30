package com.sk.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//add users for in-memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("sandy").password("password123").roles("EMPLOYEE"))
		.withUser(users.username("sandeepk").password("manage123").roles("MANAGER"))
		.withUser(users.username("admin").password("root123").roles("ADMIN"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//Restrict access based on the HttpServletRequest
		http.authorizeRequests()
		.anyRequest().authenticated()  /* any request to the app must be authenticated*/
		.and()
		.formLogin() /* for using custom login form*/
		.loginPage("/showLoginPage") /* custom login request mapping*/
		.loginProcessingUrl("/authenticateTheUser") /* post processing the login credentials behind the scenes done by spring security*/
		.permitAll() /* to allows all user to acces the login page */;
	}

	
}
