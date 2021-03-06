package com.example.wanderapp.model;


import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Blob;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 10000)
    private String password;

    @Column
    private String DOB;

    @Column(nullable = true, length = 200)
    private String profile_img = "https://cdn.filestackcontent.com/lWRNY1W7R2ub85dJca2s";

    @Column(length = 1000)
    private String bio;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isAdmin;

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        lastName = copy.lastName;
        firstName = copy.firstName;
        phoneNumber = copy.phoneNumber;
        DOB = copy.DOB;
        profile_img = copy.profile_img;
        bio = copy.bio;
        isAdmin = copy.isAdmin;
    }

    public User() {}


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="users_trails_bridge",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "trail_id")}
    )
    private List<Trail> trails;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_saved_trails_bridge",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "saved_trails_id")}
    )
    private List<CompletedTrail> completedTrail;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_friend_bridge",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")}
    )
    private List<Friend> friends;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_favorite_plants_bridge",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "favorite_plants_id")}
    )
    private List<FavoritePlants> favoritePlants;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_favorite_animals_bridge",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "favorite_animals_id")}
    )
    private List<FavoriteAnimals> favoriteAnimals;



    public List<FavoriteAnimals> getFavoriteAnimals() {
        return favoriteAnimals;
    }

    public void setFavoriteAnimals(List<FavoriteAnimals> favoriteAnimals) {
        this.favoriteAnimals = favoriteAnimals;
    }

    public List<FavoritePlants> getFavoritePlants() {
        return favoritePlants;
    }

    public void setFavoritePlants(List<FavoritePlants> favoritePlants) {
        this.favoritePlants = favoritePlants;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public List<CompletedTrail> getCompletedTrail() {
        return completedTrail;
    }

    public void setCompletedTrail(List<CompletedTrail> completedTrail) {
        this.completedTrail = completedTrail;
    }

    public List<Trail> getTrails() {
        return trails;
    }

    public void setTrails(List<Trail> trails) {
        this.trails = trails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {isAdmin = admin;}

    public String getProfile_img() {return profile_img;}

    public void setProfile_img(String profile_img) {this.profile_img = profile_img;}
}