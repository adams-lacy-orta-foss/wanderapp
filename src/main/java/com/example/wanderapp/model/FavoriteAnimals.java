package com.example.wanderapp.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "favoriteAnimals")
public class FavoriteAnimals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imageUrl;

    @ManyToMany(mappedBy = "favoriteAnimals")
    private List<Trail> trails;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
