package com.university.uch_university.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Название подразделения не может быть пустым")
    private String name;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;


    @ManyToOne
    @JoinColumn(name = "parent_department_id")
    private Department parentDepartment;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Название подразделения не может быть пустым") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Название подразделения не может быть пустым") String name) {
        this.name = name;
    }

    public Department getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Department parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public Department() {
    }

    public Department(UUID id, String name, Department parentDepartment) {
        this.id = id;
        this.name = name;
        this.parentDepartment = parentDepartment;
    }
}