package com.example.wanderapp.controllers;

import com.example.wanderapp.respository.FriendRepository;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
@Controller
public class FriendsController {
    private final FriendRepository friendsDao;

    public FriendsController(FriendRepository friendsDao) {
        this.friendsDao = friendsDao;
    }

    @GetMapping("/my-friend")
    public String viewFriends(Model model) {
        model.addAttribute("friend", friendsDao.findAll());
        return "/my-friend";
    }

}
