package com.sk.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//jdbc authentication 
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//Restrict access based on the HttpServletRequest
		http.authorizeRequests()
			//.antMatchers("/resources/**").permitAll()
			//.anyRequest().authenticated() /*  any request to the app must be authenticated*/
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/managers/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin() /* for using custom login form*/
				.loginPage("/showLoginPage") /* custom login request mapping*/
				.loginProcessingUrl("/authenticateTheUser") /* post processing the login credentials behind the scenes done by spring security*/
				.permitAll() /* to allows all user to acces the login page */
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied");/* For Custom Access Denied Page*/
	}

	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	    .antMatchers("/resources/**");
	}
	
}
