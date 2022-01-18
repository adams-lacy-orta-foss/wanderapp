package com.example.wanderapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trailPicture")
public class TrailPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String url;

    public String getUrl() {
        return url;
    }

    @ManyToMany(mappedBy = "trailPicture")
    private List<Trail> trails;

    public List<Trail> getTrails() {
        return trails;
    }

    public void setTrails(List<Trail> trails) {
        this.trails = trails;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
