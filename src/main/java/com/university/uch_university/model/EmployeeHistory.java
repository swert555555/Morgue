package com.university.uch_university.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "employeeHistory")
public class EmployeeHistory {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @NotNull(message = "Сотрудник не может быть пустым")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "change_type_id", nullable = false)
    @NotNull(message = "Тип изменения не может быть пустым")
    private ChangeType changeType;

    @NotNull(message = "Дата изменения не может быть пустой")
    private LocalDateTime changeDate;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public @NotNull(message = "Сотрудник не может быть пустым") Employee getEmployee() {
        return employee;
    }
    public void setEmployee(@NotNull(message = "Сотрудник не может быть пустым") Employee employee) {
        this.employee = employee;
    }
    public @NotNull(message = "Тип изменения не может быть пустым") ChangeType getChangeType() {
        return changeType;
    }
    public void setChangeType(@NotNull(message = "Тип изменения не может быть пустым") ChangeType changeType) {
        this.changeType = changeType;
    }
    public @NotNull(message = "Дата изменения не может быть пустой") LocalDateTime getChangeDate() {
        return changeDate;
    }
    public void setChangeDate(@NotNull(message = "Дата изменения не может быть пустой") LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public EmployeeHistory(UUID id, Employee employee, ChangeType changeType, LocalDateTime changeDate) {
        this.id = id;
        this.employee = employee;
        this.changeType = changeType;
        this.changeDate = changeDate;
    }
    public EmployeeHistory() {  }
}