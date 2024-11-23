package com.university.uch_university.repository;

import com.university.uch_university.model.Corpse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CorpseRepository extends JpaRepository<Corpse, UUID> {
}
