package com.university.uch_university.repository;

import com.university.uch_university.model.Autopsy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutopsyRepository extends JpaRepository<Autopsy, UUID> {
}
