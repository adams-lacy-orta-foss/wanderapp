package com.example.wanderapp.controllers;


import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    private final UserRepository userDao;

    public AboutUsController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model) {
//        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = userDao.findById(loginUser.getId());
//        model.addAttribute("user", user.getBio());
        return "about-us";

    }
}