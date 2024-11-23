package com.university.uch_university.repository;

import com.university.uch_university.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenderRepository extends JpaRepository<Gender, UUID> {
}
