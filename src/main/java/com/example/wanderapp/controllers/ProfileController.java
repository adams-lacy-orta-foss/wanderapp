package com.example.wanderapp.controllers;

import com.example.wanderapp.model.Trail;
import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {
	private final UserRepository userDao;
	private PasswordEncoder passwordEncoder;

	@Value("${fileStackAPIkey}")
	private String fileStackAPIkey;


	public ProfileController(UserRepository userDao, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;

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
		model.addAttribute("fsKey", fileStackAPIkey);
		model.addAttribute("user", user);
		return "profile/addProfilePhoto";
	}

	@PostMapping("/profile/add")
	public String savePhoto(@RequestParam(name = "profile_img") String img) {
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.findById(loginUser.getId());
		user.setProfile_img(img);
		userDao.save(user);
		return "redirect:/profile";
	}

	@PostMapping("/profile/delete")
	public String saveTrails(@ModelAttribute Trail trail) {
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.findById(loginUser.getId());
		userDao.delete(user);
		return "redirect:/login";
	}


	@GetMapping("/profile/password")
	public String changePassword(Model model){
		model.addAttribute("user", new User());
		return "profile";
	}

	@PostMapping("/profile/password")
	public String saveUser(@RequestParam(name = "password") String hash) {
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.findById(loginUser.getId());
		String hashed = passwordEncoder.encode(hash);
		user.setPassword(hashed);
		userDao.save(user);
		return "redirect:/profile";
	}


//	@GetMapping("/profile/password")
//	public String getPassword(Model model) {
//		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		User user = userDao.findById(loginUser.getId());
//		model.addAttribute("user", user);
//		model.addAttribute("password", loginUser.getPassword());
//		return "profile";
//	}
//
//	@PostMapping("/profile/password")
//	public String saveUser(@ModelAttribute User user){
//		String hash = passwordEncoder.encode(user.getPassword());
//		user.setPassword(hash);
//		userDao.save(user);
//		return "redirect:/profile";
//	}
}


