package com.example.wanderapp.controllers;


import com.example.wanderapp.model.FavoritePlants;
import com.example.wanderapp.model.Trail;
import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.FavoritePlantsRepository;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyPlantsController {

    private final FavoritePlantsRepository plantsdao;
    private final UserRepository userDao;

    @Value("${plantIDAPI}")
    private String plantAPIKey;

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
        model.addAttribute("plantAPIKey", plantAPIKey);
        return "my-plants";
    }

    @GetMapping("/plants/upload")
    public String uploadPlantPic(Model model) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        model.addAttribute("plantUrl", new FavoritePlants());
        model.addAttribute("plantName", new FavoritePlants());
        model.addAttribute("plantDescription", new FavoritePlants());
        model.addAttribute("userPlant", user.getFavoritePlants());
        model.addAttribute("plantAPIKey", plantAPIKey);
        return "upload-plant-pic";
    }

    @PostMapping("/plants")
    public String savePlants(@RequestParam(name="plantUrl") String plantUrl, @RequestParam(name="plantName") String plantName, @RequestParam(name="plantDescription") String plantDescription, Model model, @ModelAttribute FavoritePlants favoritePlants, @ModelAttribute String plantAPIKey) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        List<FavoritePlants> favoritePlant = user.getFavoritePlants();
        model.addAttribute("plantUrl", plantUrl);
        model.addAttribute("plantName", plantName);
        model.addAttribute("plantDescription", plantDescription);
        model.addAttribute("plantAPIKey", plantAPIKey);
//        System.out.println("plantUrl = " + plantUrl);
        favoritePlants.setimageUrl(plantUrl);
//        favoritePlants.setPlantname(plantName);
//        favoritePlants.setPlantDescription(plantDescription);
        favoritePlant.add(favoritePlants);
        user.setFavoritePlants(favoritePlant);
        userDao.save(user);
        return "redirect:/plants";
    }

    @PostMapping("/plants/delete")
    public String deletePlant(Long plantId) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        List<FavoritePlants> plantList = user.getFavoritePlants();
        plantList.remove(plantsdao.getById(plantId));
        user.setFavoritePlants(plantList);
        userDao.save(user);
        return "redirect:/plants";
    }

    @GetMapping("/plants/camera")
    public String plantCam(Model model) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        model.addAttribute("plantUrl", new FavoritePlants());
        model.addAttribute("plantName", new FavoritePlants());
        model.addAttribute("plantDescription", new FavoritePlants());
        model.addAttribute("userPlant", user.getFavoritePlants());
        model.addAttribute("plantAPIKey", plantAPIKey);
        return "test";
    }
}