package com.example.wanderapp.controllers;

import com.example.wanderapp.model.Trail;
import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.TrailRepository;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrailController {
    private TrailRepository trailDao;
    private UserRepository userDao;

    public TrailController(TrailRepository trailDao, UserRepository userDao) {
        this.trailDao = trailDao;
        this.userDao = userDao;
    }

    @GetMapping("/my-trails")
    public String trailIndex(Model model) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        model.addAttribute("trails", trailDao.findAll());
        model.addAttribute("trail", new Trail());
        return "my-trails";
    }

    @PostMapping("/my-trails")
    public String saveTrails(@ModelAttribute Trail trail) {
        trailDao.save(trail);
        return "my-trails";
    }

}
