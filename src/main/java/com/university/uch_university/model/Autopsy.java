package com.university.uch_university.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "autopsy")
public class Autopsy {
    @Id
    @GeneratedValue
    private UUID id;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    @JoinColumn(name = "corpse_id", nullable = false)
    private Corpse corpse;

    @DateTimeFormat(pattern = "dd/mm/yy hh:mm")
    @Column(nullable = false)
    private LocalDateTime autopsyDate;

    @Column(nullable = false, length = 1000)
    private String findings;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    @JoinColumn(name = "performed_by", nullable = false)
    private UserModel performedBy;

    public Autopsy(){}

    public Autopsy(UUID id, Corpse corpse, LocalDateTime autopsyDate, String findings, UserModel performedBy) {
        this.id = id;
        this.corpse = corpse;
        this.autopsyDate = autopsyDate;
        this.findings = findings;
        this.performedBy = performedBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Corpse getCorpse() {
        return corpse;
    }

    public void setCorpse(Corpse corpse) {
        this.corpse = corpse;
    }

    public @DateTimeFormat(pattern = "dd/mm/yy hh:mm") LocalDateTime getAutopsyDate() {
        return autopsyDate;
    }

    public void setAutopsyDate(LocalDateTime autopsyDate) {
        this.autopsyDate = autopsyDate;
    }

    public String getFindings() {
        return findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public UserModel getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(UserModel performedBy) {
        this.performedBy = performedBy;
    }
}