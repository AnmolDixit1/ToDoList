package com.ToDoList.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.Entities.Tasks;
import com.ToDoList.Entities.User;
import com.ToDoList.Repository.TasksRepository;
import com.ToDoList.Repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TasksRepository taskRepository;
	
	
	@GetMapping("/index")
	public  String Dashboard(Model model,Principal principal) {
		String user = principal.getName();
		User user1 = this.userRepository.getUserByUserName(user);
		
		//tasks
		List<Tasks> tasks = this.taskRepository.FindTasksByUsername(user1.getSerialNo());
		model.addAttribute("user", user1);
		model.addAttribute("tasks", tasks);
		
		
		
		return "user_dashboard";
	}
	
	
	@GetMapping("/AddContact")
	public String AddContact() {
		return "AddContact";
		
	}
	
	
	@PostMapping("/AddContactProcess")
	public String AddContactProces(@ModelAttribute("tasks") Tasks tasks,Principal principal,Model model) {
		
		String user = principal.getName();
		User user1 = this.userRepository.getUserByUserName(user);
		tasks.setStatus("Incomplete");
		user1.setToDoCount(user1.getToDoCount()+1);
		tasks.setUser(user1);
		this.taskRepository.save(tasks);
		
		
		return "redirect:/user/index";
	}
	
	
	
	@GetMapping("/Delete/{TaskNo}")
	public String Delete(Model model,Principal principal,@PathVariable("TaskNo")String TaskNo) {
		

		

		String user = principal.getName();
		User user1 = this.userRepository.getUserByUserName(user);
		

		int TaskNo1 = Integer.parseInt(TaskNo);

		
		int i = user1.getToDoCount()-1;
		user1.setToDoCount(i);
		this.taskRepository.deleteById(TaskNo1);
		
		
		
		
		model.addAttribute("user", user1);

		return "redirect:/user/index";
	}
	
	
	@GetMapping("/profile")
	public String profile(Principal principal,Model model) {
		
		String user = principal.getName()
;
		User user1 = this.userRepository.getUserByUserName(user);
		
		model.addAttribute("user",user1);
		
		
		
		return "profile";
	}
	
	@GetMapping("/update")
	public String update(Principal principal,Model m) {
		String user = principal.getName();
		User user1 = this.userRepository.getUserByUserName(user);
		m.addAttribute("user",user1);
		
		return "update";
	}
	
	
	@PostMapping("/do_updation")
	public String Updation(@RequestParam("Name") String Namee,@RequestParam("Profession") String  Professionn,Principal principal,Model model) {
		
		String user = principal.getName();
		User user1 = this.userRepository.getUserByUserName(user);
		
		
		
		if(!Namee.equals(" ")) {
			
			user1.setName(Namee);
			this.userRepository.save(user1);
		}
		
        if(!Professionn.equals(" ")) {
			
			user1.setProfession(Professionn);
			this.userRepository.save(user1);
		}
        
        model.addAttribute("user",user1);
		
		
		
		
		
		
		
		return "redirect:/user/profile";
	}
	
	

}




















