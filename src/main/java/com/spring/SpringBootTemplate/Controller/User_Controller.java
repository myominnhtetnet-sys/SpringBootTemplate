package com.spring.SpringBootTemplate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
			return "redirect:/user/list";
		}
		else {
			return "Create_Form";
		}
	}
	
	@GetMapping("/list")
	public String getAllUsers(Model model) {
		List<User_Bean> users = userRepo.getAllUsers();
		model.addAttribute("users", users);
		return "user_list";
	}
	
}
