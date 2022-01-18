package com.example.wanderapp.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trailMap")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private boolean isPublic;

    @ManyToMany(mappedBy = "trailMap")
    private List<Trail> trails;

    public List<Trail> getTrails() {
        return trails;
    }

    public void setTrails(List<Trail> trails) {
        this.trails = trails;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
