package com.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/security")
public class MyController {
	@RequestMapping("/emplist")
	public String viewHomePage() {
		return "products.html";
	}
}
