package com.example.wanderapp.controllers;

import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	private UserRepository userDao;

	public UserController(UserRepository userDao) {
		this.userDao = userDao;
	}

	@GetMapping("/sign-up")
	public String showSignupForm(Model model){
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/sign-up")
	public String saveUser(@ModelAttribute User user){
		userDao.save(user);
		return "redirect:/login";
	}
}