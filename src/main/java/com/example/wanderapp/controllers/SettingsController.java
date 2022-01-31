package com.example.wanderapp.controllers;


import com.example.wanderapp.model.FavoritePlants;
import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SettingsController {
    private final UserRepository userDao;

    @Value("${fileStackAPIkey}")
    private String fileStackAPIkey;


    public SettingsController(UserRepository userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/settings")
    public String editProfile( Model model){
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        model.addAttribute("fsKey",fileStackAPIkey);
        model.addAttribute("user", user);
        model.addAttribute("imgUrl", user.getProfile_img());
        return "settings";
    }

    @PostMapping("/settings")
    public String saveEditPost(@RequestParam(name="FirstName") String FirstName, @RequestParam(name="LastName") String LastName, @RequestParam(name="Id") long id, @RequestParam(name="img") String img, @RequestParam(name="Email") String email, @RequestParam(name="DOB") String DOB, Model model) {

        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        model.addAttribute("Profile_img", img);
        System.out.println("img = " + img);

        user.setFirstName(FirstName);
        user.setLastName(LastName);
        user.setProfile_img(img);
        user.setEmail(email);
        user.setDOB(DOB);


        userDao.save(user);

        return "redirect:/profile";
    }
}