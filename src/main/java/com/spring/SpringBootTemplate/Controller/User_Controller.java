package com.spring.SpringBootTemplate.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		ModelAndView mv = new ModelAndView("Create_Form","userObj",new User_Bean());
		mv.addObject("activePage", "createUser");
		return mv;
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
		model.addAttribute("activePage", "userList");
//		return "user_list";
		return "user_list_fact";
	}
	
	@GetMapping("/edit/{id}")
	@ResponseBody
	public User_Bean getById(@PathVariable("id") Integer id) {
		User_Bean user = userRepo.getById(id);
//		return new ModelAndView("Edit_Form","userObj",user);
		return user;
	}

	
	@PostMapping("/update")
	public String updateUser(@RequestBody User_Bean user) {
	    int i = userRepo.updateUser(user);
	    return "redirect:/user/list";
	}
	
	
//	@PostMapping("/update")
//	public String updateUser(@ModelAttribute("userObj") User_Bean user) {
//		int i = userRepo.updateUser(user);
//		if(i>0) {
//			return "redirect:/user/list";
//		}
//		else {
//			return "Edit_Form";
//		}
//	}
	
	@PostMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		int i = userRepo.deleteUser(id);
		if(i>0) {
			return "redirect:/user/list";
		}
		else {
			return "user_list";
		}
	}
}
