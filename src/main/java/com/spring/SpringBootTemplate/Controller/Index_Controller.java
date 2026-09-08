package com.spring.SpringBootTemplate.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index_Controller {
	@Controller
	public class WebController {

	    @GetMapping("/")
	    public String home(Model model) {
	        model.addAttribute("activePage", "home");
	        return "index"; 
	    }

	    @GetMapping("/shop")
	    public String shop(Model model) {
	        model.addAttribute("activePage", "shop");
	        return "shop"; 
	    }
	    
		@GetMapping("/list")
		public String showList(Model model) {
			List<String> list = new ArrayList<String>();
			list.add("Java");
			list.add("PHP");
			list.add("Python");
			model.addAttribute("list", list);
			return "list";
		}
	}

}
