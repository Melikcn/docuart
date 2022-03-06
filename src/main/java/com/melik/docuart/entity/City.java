package com.melik.docuart.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "plaka")
    private int plaka;

    public City() {
    }

    public City(@JsonProperty("id") Integer id,
                @JsonProperty("city") String city,
                @JsonProperty("plaka") int plaka) {
        this.id = id;
        this.city = city;
        this.plaka = plaka;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", plaka=" + plaka +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getPlaka() {
        return plaka;
    }
}
