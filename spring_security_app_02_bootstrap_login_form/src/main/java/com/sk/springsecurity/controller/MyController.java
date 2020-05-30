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
}
