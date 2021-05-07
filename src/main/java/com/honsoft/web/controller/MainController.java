package com.honsoft.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/home")
	public String home(Model m) {
		m.addAttribute("message", "Hello spring");
		return "thymeleaf/home";
	}
	
	@GetMapping("/homejsp")
	public String homejsp(Model m) {
		m.addAttribute("message", "Hello spring");
		return "home";
	}
	
	@GetMapping("/welcome")
	public String welcome(Model m) {
		m.addAttribute("message", "Hello spring");
		return "welcome";
	}
	
	
	@GetMapping("/user")
	public String user(Model m) {
		m.addAttribute("message", "Hello spring");
		return "user";
	}
	
	
	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("message", "Hello spring");
		return "thymeleaf/login";
	}
	
}
