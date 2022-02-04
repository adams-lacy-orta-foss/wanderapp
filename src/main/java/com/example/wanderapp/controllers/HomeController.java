package com.example.wanderapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Value("${mapBoxAPIkey}")
    private String mapboxAPIkey;

	@GetMapping("/index")
	public String welcome(Model model){
		model.addAttribute("mapboxAPIkey", mapboxAPIkey);
		return "index";
	}

	@GetMapping("/")
	public String welcomeNoUrl(Model model){
		model.addAttribute("mapboxAPIkey", mapboxAPIkey);
		return "index";
	}
}