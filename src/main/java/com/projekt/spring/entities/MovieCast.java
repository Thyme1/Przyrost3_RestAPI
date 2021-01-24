package com.projekt.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MovieCast")

public class MovieCast {


    @Column(name="id")
    @Id
    private Long id;

    @Column(nullable=false)
    String role;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//    @JsonManagedReference(value="act")
    @JsonIgnore
    @JoinColumn(name="actorId", nullable=false)
    private Actors actorId;

    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="movieId", nullable=false)
    @JsonIgnore
    private hibernate.model.Movie movieId;


    public hibernate.model.Movie getMovie() {
        return movieId;
    }

    public void setMovie(hibernate.model.Movie movie) {
        this.movieId=movie;
    }

    public Actors getActor() {
        return actorId;
    }

    public void setActor(Actors actor) {
        this.actorId=actor;
    }

    public MovieCast() {
    }

    public Actors getActorId() {
        return actorId;
    }

    public void setActorId(Actors actorId) {
        this.actorId=actorId;
    }

    public hibernate.model.Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(hibernate.model.Movie movieId) {
        this.movieId=movieId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role=role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

}