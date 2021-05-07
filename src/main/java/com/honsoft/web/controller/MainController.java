package com.honsoft.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("message", "Hello spring");
		return "thymeleaf/index";
	}
	
	
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
	
	

	@GetMapping("/user/index")
	public String userIndex(Model m) {
		m.addAttribute("message", "Hello spring");
		return "thymeleaf/home";
	}
	

}
