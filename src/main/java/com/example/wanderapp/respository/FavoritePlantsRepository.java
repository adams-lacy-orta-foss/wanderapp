package com.example.wanderapp.respository;

import com.example.wanderapp.model.FavoritePlants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritePlantsRepository extends JpaRepository<FavoritePlants, Long> {

}
