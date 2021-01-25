package com.projekt.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = {
        "name",
        "surname",
        "age",
        "gender",
        "salary",
        "favGenre",
        "address",
        "movies"
})


@Entity(name = "Actors")
@Table(name = "actors")
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String actorID;
    @Column(nullable=false)
    String name;
    @Column(nullable=false)
    String surname;
    @Column(nullable=false)
    Integer age;
    @Column
    String gender;
    @Column(nullable=false)
    Integer salary;
    @Column
    String favGenre;


    //required by Hibernate
    public Actors(){

    }

    public Actors(String actorID, String name, String surname, Integer age, String gender, Integer salary, String favGenre, Address address ) {
        this.actorID = actorID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.favGenre = favGenre;
        this.address = address;
        this.movies = movies;
    }

    @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
    @JoinColumn(name="address_id")
    Address address;

    @OneToMany(mappedBy="actorId",fetch=FetchType.EAGER)
//    @JsonBackReference(value="act")
    private Set<MovieCast> movies;


    Set<MovieCast> getMovies() {
        return movies;
    }
    public void setMovies(Set<MovieCast> movies) {
        this.movies=movies;
    }

    String getFavGenre() {
        return favGenre;
    }



    public void setFavGenre(String favGenre) {
        this.favGenre=favGenre;
    }

    @JsonProperty("ActorId")
    public String getActorsId() {
        return actorID;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer idAct) {
        this.id=idAct;
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
    public void setSurname(String surname) {
        this.surname=surname;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age=age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender=gender;
    }


    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary=salary;
    }

    public void setAddress(Address address1) {
        this.address=address1;
    }
    @JsonIgnore
    public Integer counter = 50;


    public Address getAddress() {
        if(address != null)
            return address;
        else{ counter=counter+1;
            Address adresNull = new Address();
            adresNull.setId(counter++);
            return adresNull ;}
    }



    public String getActorID() {
        return actorID;
    }

    public void setActorID(String actorID) {
        this.actorID=actorID;
    }
}