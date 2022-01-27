package com.example.wanderapp.controllers;


import com.example.wanderapp.model.FavoritePlants;
import com.example.wanderapp.respository.FavoritePlantsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPlantsController {

    private final FavoritePlantsRepository plantsdao;

    public MyPlantsController(FavoritePlantsRepository plantsDao) {
        this.plantsdao = plantsDao;
    }

    @GetMapping("/plants")
    public String viewPlants(Model model) {
        model.addAttribute("plants", plantsdao.findAll());
        return "my-plants";
    }

    @GetMapping("/plants/upload")
    public String savePlantPic(Model model) {
        return "upload-plant-pic";
    }

}
