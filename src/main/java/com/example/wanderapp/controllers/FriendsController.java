package com.example.wanderapp.controllers;

import com.example.wanderapp.model.FavoritePlants;
import com.example.wanderapp.model.Friend;
import com.example.wanderapp.model.User;
import com.example.wanderapp.respository.FriendRepository;
import com.example.wanderapp.respository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Column;
import java.util.List;

@Controller
public class FriendsController {
    private final FriendRepository friendsDao;
    private final UserRepository userDao;

    public FriendsController(FriendRepository friendsDao, UserRepository userDao) {
        this.friendsDao = friendsDao;
        this.userDao = userDao;
    }

    @GetMapping("/all-friends")
    public String viewFriends(Model model) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        model.addAttribute("friends", new Friend());
        model.addAttribute("friend", user.getFriends());
        return "/my-friend";
    }

    @PostMapping("/all-friends")
    public String saveFriends(@ModelAttribute Friend friend) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        List<Friend> friends = user.getFriends();
        friends.add(friend);
        user.setFriends(friends);
        userDao.save(user);
        return "redirect:/all-friends";
    }

    @PostMapping ("/all-friends/delete")
    public String deleteTrail(Long friendId) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loginUser.getId());
        List<Friend> friendsList = user.getFriends();
        friendsList.remove(friendsDao.getById(friendId));
        user.setFriends(friendsList);
        userDao.save(user);
        return "redirect:/plants";
    }

}
