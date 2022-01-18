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

    @ManyToMany(mappedBy = "favoritePlants")
    private List<Trail> trails;

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
