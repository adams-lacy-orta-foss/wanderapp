package com.example.wanderapp.respository;

import com.example.wanderapp.model.Trail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailRepository  extends JpaRepository <Trail, Long>{

}
