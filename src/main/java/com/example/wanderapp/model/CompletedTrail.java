package com.example.wanderapp.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "completedTrail")
public class CompletedTrail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String completedTrail;

    @Column
    private boolean isCompleted;

    @Column
    private boolean isPublic;

    @Column
    private boolean isSaved;

    public boolean isSaved() {
        return isSaved;
    }

    public List<Trail> getTrails() {
        return trails;
    }

    public void setTrails(List<Trail> trails) {
        this.trails = trails;
    }

    @ManyToMany(mappedBy = "completedTrail")
    private List<Trail> trails;

    @ManyToMany(mappedBy = "completedTrail")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

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
