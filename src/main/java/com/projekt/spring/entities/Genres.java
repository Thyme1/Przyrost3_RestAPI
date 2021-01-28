package com.projekt.spring.entities;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Genres")

public class Genres {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String genreId;

    @Column(nullable=false)
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public Genres() {
    }

    public Genres(String genreId, String name) {
        this.genreId=genreId;
        this.name=name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId=genreId;
    }
}