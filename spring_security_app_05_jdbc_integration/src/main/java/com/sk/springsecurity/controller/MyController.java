package com.sk.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/")
	public String showHome() {
		System.out.println("inside showHome ##");
		return "home";
	}
	
	@GetMapping("/managers")
	public String showManagers() {
		System.out.println("inside showManagers ##");
		return "managers";
	}
	
	@GetMapping("/systems")
	public String showSystemForAdmin() {
		System.out.println("inside showSystemForAdmin ##");
		return "systems";
	}
}
