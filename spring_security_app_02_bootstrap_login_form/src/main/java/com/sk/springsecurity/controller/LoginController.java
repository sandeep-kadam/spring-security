package com.sk.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	/*@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "simple-login";
	}*/
	
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		System.out.println("inside showLoginPage ###");
		return "bootstrap-login";
	}
	
}
