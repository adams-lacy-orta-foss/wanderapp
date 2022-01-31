package com.example.wanderapp.controllers;

import com.example.wanderapp.model.Trail;
import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.TrailRepository;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        model.addAttribute("trails", user.getTrails());
        model.addAttribute("trail", new Trail());
        return "my-trails";
    }

    @PostMapping("/my-trails")
    public String saveTrails(@ModelAttribute Trail trail) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        List<Trail> trailList = user.getTrails();
        trailList.add(trail);
        user.setTrails(trailList);
        userDao.save(user);
        return "redirect:/my-trails";
    }

    @PostMapping ("/my-trails/delete")
    public String deleteTrail(Long trailId) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        List<Trail> trailList = user.getTrails();
        System.out.println(trailList);
        trailList.remove(trailDao.getById(trailId));
        user.setTrails(trailList);
        userDao.save(user);
        return "redirect:/my-trails";
    }

}
