package com.example.wanderapp.model;


import javax.persistence.*;

@Entity
@Table(name = "completedTrail")
public class CompletedTrail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String completedTrail;

    public String getCompletedTrail() {
        return completedTrail;
    }

    public void setCompletedTrail(String completedTrail) {
        this.completedTrail = completedTrail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
