package com.university.uch_university.repository;

import com.university.uch_university.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PositionRepository extends JpaRepository<Position, UUID> {
}