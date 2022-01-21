package com.example.wanderapp.controllers;

import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
	private final UserRepository userDao;

	public ProfileController(UserRepository userDao) {
		this.userDao = userDao;
	}

	@GetMapping("/profile")
	public String profile(Model model) {
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.findById(loginUser.getId());
		model.addAttribute("user", user);
		return "profile";
	}
}