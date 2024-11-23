package com.university.uch_university.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "corpse")
public class Corpse {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Min(value = 0, message = "Возраст не может быть меньше нуля")
    private Integer age;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne(mappedBy = "corpse", cascade = CascadeType.ALL)
    private DeathCertificate deathCertificate;
    @DateTimeFormat(pattern = "dd/MM/yy hh:mm")
    @Column(nullable = false)
    private LocalDateTime receiptDate;


    public Corpse(UUID id, String name, Integer age, Gender gender, DeathCertificate deathCertificate, LocalDateTime receiptDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.deathCertificate = deathCertificate;
        this.receiptDate = LocalDateTime.now();
    }

    public @DateTimeFormat(pattern = "dd/MM/yy hh:mm") LocalDateTime getReceiptDate() {
        return receiptDate;
    }

    public Corpse() {
        this.receiptDate = LocalDateTime.now();
    }

    // Геттеры и сеттеры
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public DeathCertificate getDeathCertificate() {
        return deathCertificate;
    }

    public void setDeathCertificate(DeathCertificate deathCertificate) {
        this.deathCertificate = deathCertificate;
    }

    public void setReceiptDate(LocalDateTime receiptDate) {
        this.receiptDate = receiptDate;
    }
}