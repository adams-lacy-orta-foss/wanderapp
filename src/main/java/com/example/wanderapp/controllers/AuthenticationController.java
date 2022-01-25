package com.example.wanderapp.controllers;

import com.example.wanderapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

	@GetMapping("/login")
	public String showLoginForm(Model model){
		model.addAttribute("user", new User());
		return "/login";
	}
}