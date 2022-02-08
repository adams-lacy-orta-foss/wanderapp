package com.example.wanderapp.model;


import javax.persistence.*;

@Entity
@Table(name = "PreSavedTrails")
public class PreSavedTrails {

    //(saved_trail_name, saved_trail_length, saved_trail_head_location, saved_trail_description
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String savedTrailName;

    @Column
    private double savedTrailLength;


    @Column(length = 1000)
    private String savedTrailHeadLocation;

    @Column(length = 10000)
    private String savedTrailDescription;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSavedTrailName() {
        return savedTrailName;
    }

    public void setSavedTrailName(String savedTrailName) {
        this.savedTrailName = savedTrailName;
    }

    public double getSavedTrailLength() {
        return savedTrailLength;
    }

    public void setSavedTrailLength(double savedTrailLength) {
        this.savedTrailLength = savedTrailLength;
    }

    public String getSavedTrailHeadLocation() {
        return savedTrailHeadLocation;
    }

    public void setSavedTrailHeadLocation(String savedTrailHeadLocation) {
        this.savedTrailHeadLocation = savedTrailHeadLocation;
    }

    public String getSavedTrailDescription() {
        return savedTrailDescription;
    }

    public void setSavedTrailDescription(String savedTrailDescription) {
        this.savedTrailDescription = savedTrailDescription;
    }
}
