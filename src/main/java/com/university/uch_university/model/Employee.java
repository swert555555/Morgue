package com.university.uch_university.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
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
    @NotNull(message = "Дата изменения не может быть пустой")
    private LocalDateTime hireDate;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true, nullable = true)
    private UserModel user;

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
    public @NotNull(message = "Дата изменения не может быть пустой") LocalDateTime getHireDate() {
        return hireDate;
    }
    public void setHireDate(@NotNull(message = "Дата изменения не может быть пустой") LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }

    public Employee() {}

    public Employee(UUID id, String firstName, String lastName, LocalDateTime hireDate, Position position, Department department, UserModel user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;
        this.hireDate = hireDate;
        this.user = user;
    }
}