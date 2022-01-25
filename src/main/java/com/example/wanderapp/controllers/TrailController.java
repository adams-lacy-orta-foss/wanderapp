package com.example.wanderapp.controllers;

import com.example.wanderapp.model.Trail;
import com.example.wanderapp.respository.TrailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrailController {
	private TrailRepository trailDao;

	public TrailController(TrailRepository trailDao) {
		this.trailDao = trailDao;}

	@GetMapping("/my-trails")
	public String trailIndex (Model model) {
		model.addAttribute("trails", trailDao.findAll());
		return "my-trails";
	}

	@PostMapping("/my-trails")
	public String saveTrails(@ModelAttribute Trail trail) {
		trailDao.save(trail);
		return "my-trails";
	}

}
