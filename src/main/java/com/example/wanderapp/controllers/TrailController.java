package com.example.wanderapp.controllers;

import com.example.wanderapp.respository.TrailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrailController {
	private TrailRepository trailDao;

	public TrailController(TrailRepository trailDao) {
		this.trailDao = trailDao;}

	@GetMapping("/trails")
	public String trailIndex (Model model) {
		model.addAttribute("trails", trailDao.findAll());

		return "trails";
	}
}
