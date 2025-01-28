package com.university.uch_university.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Название должности не может быть пустым")
    private String title;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public @NotBlank(message = "Название должности не может быть пустым") String getTitle() {
        return title;
    }
    public void setTitle(@NotBlank(message = "Название должности не может быть пустым") String title) {
        this.title = title;
    }

    public Position(){}
    public Position(UUID id, String title) {
        this.id = id;
        this.title = title;
    }
}