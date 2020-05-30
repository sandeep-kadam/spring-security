package com.sk.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.sk.springsecurity")
public class AppConfig {

	
	/**
	 * Annotation Description
	 * 
	 * @Configurationn Sets a class as a Java Configuration Class for Spring MVC
	 * @EnableWebMvc : provides similar support like <mvc:annotation-driven> xml property gives in applicationContext.xml file.
	 * @ComponentScan : to provide packages which needs to be scan by spring 
	 * 
	 */
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
}
