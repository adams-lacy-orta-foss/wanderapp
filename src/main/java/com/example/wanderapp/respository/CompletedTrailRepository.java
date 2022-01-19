package com.example.wanderapp.respository;

import com.example.wanderapp.model.CompletedTrail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedTrailRepository extends JpaRepository<CompletedTrail, Long> {

}
