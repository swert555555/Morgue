package com.university.uch_university.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;
    @NotBlank(message = "Фамилия не может быть пустым")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public @NotBlank(message = "Имя не может быть пустым") String getFirstName() {
        return firstName;
    }
    public void setFirstName(@NotBlank(message = "Имя не может быть пустым") String firstName) {
        this.firstName = firstName;
    }
    public @NotBlank(message = "Фамилия не может быть пустым") String getLastName() {
        return lastName;
    }
    public void setLastName(@NotBlank(message = "Фамилия не может быть пустым") String lastName) {
        this.lastName = lastName;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {}

    public Employee(UUID id, String firstName, String lastName, Position position, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;
    }
}