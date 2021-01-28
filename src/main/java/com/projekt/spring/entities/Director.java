package com.projekt.spring.entities;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="Directors")

public class Director {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    @Column
    private String directorId;

    @Column(nullable=false)
    String name;

    @Column(nullable=false)
    String surname;

    @OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(name="add_id")
    Address address;

    @OneToMany(mappedBy="director", fetch=FetchType.EAGER)
    private Set<Movie> movies;


    public Director() {
    }

    public Director(String name, String surname, Address address, Set<Movie> movies) {
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.movies=movies;
    }

    Director(String directorId) {
        this.directorId=directorId;
    }

    Set<Movie> getMovies() {
        return movies;
    }

    void setMovies(Set<Movie> movies) {
        this.movies=movies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String city) {
        this.surname=city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address=address;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId=directorId;
    }

}