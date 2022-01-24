package com.example.wanderapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllTrailsController {

    @GetMapping("all-trails")
    public String allTrails() {
        return "all-trails";
    }
}