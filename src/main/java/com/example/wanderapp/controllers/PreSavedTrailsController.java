package com.example.wanderapp.controllers;


import com.example.wanderapp.respository.PreSavedTrailsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PreSavedTrailsController {

    private PreSavedTrailsRepository preSavedTrailDao;

    public PreSavedTrailsController(PreSavedTrailsRepository preSavedTrailDao) {
        this.preSavedTrailDao = preSavedTrailDao;
    }

    @GetMapping("/all-trails")
    public String savedTrails(Model model) {
        model.addAttribute("trails", preSavedTrailDao.findAll());
        return "all-trails";
    }

}
