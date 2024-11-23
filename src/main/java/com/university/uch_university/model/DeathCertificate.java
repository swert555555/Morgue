package com.university.uch_university.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "deathCertificate")
public class DeathCertificate {
    @Id
    @GeneratedValue
    private UUID id;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne
    @JoinColumn(name = "corpse_id", nullable = false)
    private Corpse corpse;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    @JoinColumn(name = "cause_of_death_id", nullable = false)
    private CauseOfDeath causeOfDeath;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City placeOfDeath;

    public DeathCertificate(){}

    public DeathCertificate(UUID id, Corpse corpse, CauseOfDeath causeOfDeath, City placeOfDeath) {
        this.id = id;
        this.corpse = corpse;
        this.causeOfDeath = causeOfDeath;
        this.placeOfDeath = placeOfDeath;
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

    public CauseOfDeath getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(CauseOfDeath causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public City getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(City placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }
}