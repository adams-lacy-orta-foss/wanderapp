//package com.example.wanderapp.controllers;
//
//
//import com.example.wanderapp.respository.TrailRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class AllTrailsController {
//    private final TrailRepository trailDao;
//
//    public AllTrailsController(TrailRepository trailDao) {
//        this.trailDao = trailDao;
//    }
//
//    @GetMapping("/all-trails")
//    public String allTrails(Model model) {
//        model.addAttribute("trails", trailDao.findAll());
//        return "all-trails";
//    }
//}