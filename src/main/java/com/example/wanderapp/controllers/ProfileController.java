package com.example.wanderapp.controllers;

import com.example.wanderapp.respository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
	private final UserRepository userDao;

    public ProfileController(UserRepository userDao) {
        this.userDao = userDao;
    }

	@GetMapping("/profile/{username}")
	public String profile(@PathVariable String username, Model model) {
		model.addAttribute("viewProfile", userDao.findByUsername(username));
		return "profile";
	}
}