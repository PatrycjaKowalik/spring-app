package com.wine.wines;

import org.springframework.stereotype.Controller;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
@Table(name = "wines")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String grapes;

    @Column
    private String country;

    @Column
    private Integer year;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrapes() {
        return grapes;
    }

    public void setGrapes(String grapes) {
        this.grapes = grapes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }




    @Override
    public String toString(){
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grapes='" + grapes + '\'' +
                ", country='" + country + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
