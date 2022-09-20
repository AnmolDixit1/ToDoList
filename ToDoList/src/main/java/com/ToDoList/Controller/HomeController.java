package com.ToDoList.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ToDoList.Entities.User;
import com.ToDoList.Repository.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private BCryptPasswordEncoder  passwordEncoder;
	
	
	//Home page controller
	@GetMapping("/")
	public String Home() {
		return "HomePage";
	}
	
	@GetMapping("/Register")
	public String Register() {
		return "register";
	}
	
	@PostMapping("/do_registration")
	public String DoRegistration(@ModelAttribute("user") User user,Model model) {
		
		//Testing purpose only
		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User result = this.userrepository.save(user);
		
		model.addAttribute("user", new User());
		
		
		return "register";
	}
	
	@GetMapping("/signin")
    public String customLogin(Model model) {
			
		model.addAttribute("title","LOGIN PAGE");	
    	return "login";
    	
    }

}
