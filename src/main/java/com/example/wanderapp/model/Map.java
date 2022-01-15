package com.example.wanderapp.model;


import javax.persistence.*;

@Entity
@Table(name = "trailMap")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private boolean isPublic;

}
