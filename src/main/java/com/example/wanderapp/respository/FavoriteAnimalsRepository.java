package com.example.wanderapp.respository;

import com.example.wanderapp.model.FavoriteAnimals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteAnimalsRepository extends JpaRepository<FavoriteAnimals, Long> {

}
