package com.spring.SpringBootTemplate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminCOntroller {
	
	@GetMapping("/adim")
	public String showAdmin() {
		return "admin";
	}

}
