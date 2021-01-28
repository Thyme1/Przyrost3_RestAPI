package com.projekt.spring.entities;

import com.fasterxml.jackson.annotation.*;
import org.joda.time.DateTime;

import javax.persistence.*;


import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="Movies")

public class Movie {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String movieId;

    @Column(nullable=false)
    String title;

    @Column(nullable=false)
    String time;

    @Column(nullable=false)
    String language;


    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(length=1000)
    DateTime releaseDate;

    @Column(nullable=false)
    String releaseCountry;

    @Column
    String movieGenre;


    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="dir")

    private Director director;


    @OneToMany(mappedBy="movieId", cascade=CascadeType.ALL)
//    @JsonBackReference(value="act2")
    @JsonIgnore
    private Set<MovieCast> actors;

    public Movie() {
    }

    public Movie(String movieId, String title, String time, String language, DateTime releaseDate, String releaseCountry, String movieGenre, Director director, Set<MovieCast> actors) {
        this.movieId=movieId;
        this.title=title;
        this.time=time;
        this.language=language;
        this.releaseDate=releaseDate;
        this.releaseCountry=releaseCountry;
        this.movieGenre=movieGenre;
        this.director=director;
        this.actors=actors;
    }

    Movie(String movieId) {


    }

    public Set<MovieCast> getActors() {
        return actors;
    }

    public void setActors(Set<MovieCast> actors) {
        this.actors=actors;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre=movieGenre;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time=time;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language=language;
    }

    public DateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(DateTime releaseDate) {
        this.releaseDate=releaseDate;
    }

    public String getReleaseCountry() {
        return releaseCountry;
    }

    public void setReleaseCountry(String releaseCountry) {
        this.releaseCountry=releaseCountry;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director=director;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId=movieId;
    }
}