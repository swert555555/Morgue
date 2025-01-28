package com.university.uch_university.repository;

import com.university.uch_university.model.ChangeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChangeTypeRepository extends JpaRepository<ChangeType, UUID> {
}
