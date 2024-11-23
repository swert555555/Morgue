package com.university.uch_university.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    public City(){  }

    public City(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

