package com.example.wanderapp.controllers;

import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
	private final UserRepository userDao;

	@Value("${fileStackAPIkey}")
	private String fileStackAPIkey;


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

	@GetMapping("/profile/add")
	public String viewAddProfilePhoto(Model model) {
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.findById(loginUser.getId());
		model.addAttribute("fsKey",fileStackAPIkey);
		model.addAttribute("user", user);
		return "profile/addProfilePhoto";
	}

	@PostMapping("/profile/add")
	public String savePhoto(@RequestParam(name="defaultimg") String img){
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.findById(loginUser.getId());
		user.setDefaultimg(img);
		userDao.save(user);
		return "redirect:/profile";
	}
}