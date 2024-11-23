package com.university.uch_university.repository;

import com.university.uch_university.model.CauseOfDeath;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CauseOfDeathRepository extends JpaRepository<CauseOfDeath, UUID> {
}
