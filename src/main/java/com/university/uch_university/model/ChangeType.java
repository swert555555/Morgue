package com.university.uch_university.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "changeType")
public class ChangeType {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Название типа изменения не может быть пустым")
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Название типа изменения не может быть пустым") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Название типа изменения не может быть пустым") String name) {
        this.name = name;
    }

    public ChangeType(){}

    public ChangeType(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
