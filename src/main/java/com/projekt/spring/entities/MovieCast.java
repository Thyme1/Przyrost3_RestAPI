package com.projekt.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MovieCast")

public class MovieCast {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String movieCastId;

    @Column(nullable=false)
    String role;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="actorId", nullable=false)
    private Actors actorId;

    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="movieId", nullable=false)
    @JsonIgnore
    private Movie movieId;


    public MovieCast() {
    }

    public MovieCast(String movieCastId, String role, Actors actorId, Movie movieId) {
        this.movieCastId=movieCastId;
        this.role=role;
        this.actorId=actorId;
        this.movieId=movieId;
    }

    MovieCast(String movieCastId) {

    }

    public Movie getMovie() {
        return movieId;
    }

    public void setMovie(Movie movie) {
        this.movieId=movie;
    }

    public Actors getActor() {
        return actorId;
    }

    public void setActor(Actors actor) {
        this.actorId=actor;
    }

    public Actors getActorId() {
        return actorId;
    }

    public void setActorId(Actors actorId) {
        this.actorId=actorId;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId=movieId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role=role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getMovieCastId() {
        return movieCastId;
    }

    public void setMovieCastId(String movieCastId) {
        this.movieCastId=movieCastId;
    }
}