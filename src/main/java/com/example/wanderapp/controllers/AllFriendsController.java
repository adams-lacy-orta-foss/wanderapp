package com.example.wanderapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllFriendsController {

    @GetMapping("/my-friends")
    public String allFriends() {
        return "all-friends";
    }
}