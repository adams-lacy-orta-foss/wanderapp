package com.example.wanderapp.controllers;


import com.example.wanderapp.model.FavoritePlants;
import com.example.wanderapp.model.Trail;
import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.FavoritePlantsRepository;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyPlantsController {

    private final FavoritePlantsRepository plantsdao;
    private final UserRepository userDao;

    public MyPlantsController(FavoritePlantsRepository plantsDao, UserRepository userDao) {
        this.plantsdao = plantsDao;
        this.userDao = userDao;
    }

    @GetMapping("/plants")
    public String viewPlants(Model model) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        model.addAttribute("plant", new FavoritePlants());
        model.addAttribute("plants", user.getFavoritePlants());
        return "my-plants";
    }

    @GetMapping("/plants/upload")
    public String uploadPlantPic(Model model) {
        model.addAttribute("plantUrl", new FavoritePlants());
        return "upload-plant-pic";
    }

//    @PostMapping("/plants")
//    public String savePlantPic(@ModelAttribute FavoritePlants favoritePlants){
//    }

    @PostMapping("/plants")
    public String savePlants(@ModelAttribute FavoritePlants favoritePlants) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        List<FavoritePlants> favoritePlant = user.getFavoritePlants();
//        model.addAttribute("plantUrl", favoritePlants.getimageUrl());
        System.out.println();
        favoritePlant.add(favoritePlants);
        user.setFavoritePlants(favoritePlant);
        userDao.save(user);
        return "redirect:/plants";
    }
}
