package com.example.wanderapp.respository;

import com.example.wanderapp.model.Friend;
import com.example.wanderapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {

}
