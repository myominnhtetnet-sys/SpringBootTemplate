package com.spring.SpringBootTemplate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.SpringBootTemplate.Model.User_Bean;
import com.spring.SpringBootTemplate.Repository.User_Repository;

@Controller
@RequestMapping("/user")
public class User_Controller {
	@Autowired
	User_Repository userRepo;
	
	@GetMapping("/form")
	public ModelAndView showUserForm() {
		return new ModelAndView("Create_Form","userObj",new User_Bean());
	}
	
	@PostMapping("/create")
	public String createUser(@ModelAttribute("userObj") User_Bean user) {
		int i = userRepo.insertUser(user);
		if(i>0) {
			return "";
		}
		else {
			return "";
		}
	}
	
}
