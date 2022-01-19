package com.example.wanderapp.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @ManyToMany(mappedBy = "friends")
    private List<User> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "friend_favorite_animal_bridge",
            joinColumns = {@JoinColumn(name = "friend_id")},
            inverseJoinColumns = {@JoinColumn(name = "favorite_animal_id")}
    )
    private List<FavoriteAnimals> favoriteAnimals;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "friend_favorite_plants_bridge",
            joinColumns = {@JoinColumn( name = "friend_id")},
            inverseJoinColumns = {@JoinColumn(name = "favorite_plant_id")}
    )
    private List<FavoritePlants> favoritePlants;


    public List<FavoritePlants> getFavoritePlants() {
        return favoritePlants;
    }

    public void setFavoritePlants(List<FavoritePlants> favoritePlants) {
        this.favoritePlants = favoritePlants;
    }

    public List<FavoriteAnimals> getFavoriteAnimals() {
        return favoriteAnimals;
    }

    public void setFavoriteAnimals(List<FavoriteAnimals> favoriteAnimals) {
        this.favoriteAnimals = favoriteAnimals;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
