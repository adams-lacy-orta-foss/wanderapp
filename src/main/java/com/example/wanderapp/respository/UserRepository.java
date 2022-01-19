package com.example.wanderapp.respository;

import com.example.wanderapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

	Object findByUserName(String username);
}
