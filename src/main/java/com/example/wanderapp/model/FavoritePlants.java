package com.example.wanderapp.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "favoritePlants")
public class FavoritePlants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String url;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Trail> getTrails() {
        return trails;
    }

    public void setTrails(List<Trail> trails) {
        this.trails = trails;
    }

    @ManyToMany(mappedBy = "favoritePlants")
    private List<Trail> trails;

    @ManyToMany(mappedBy = "favoritePlants")
    private List<User> user;

    public String getUrl() {
        return url;
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
