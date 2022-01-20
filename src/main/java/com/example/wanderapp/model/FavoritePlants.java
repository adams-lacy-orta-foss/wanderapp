package com.example.wanderapp.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "favoritePlants")
public class FavoritePlants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imageUrl;

    @ManyToMany(mappedBy = "favoritePlants")
    private List<Trail> trails;

    @ManyToMany(mappedBy = "favoritePlants")
    private List<User> user;

    @ManyToMany(mappedBy = "favoritePlants")
    private List<Friend> friends;

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

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

    public String getimageUrl() {
        return imageUrl;
    }

    public void setimageUrl(String url) {
        this.imageUrl = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
