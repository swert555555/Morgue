package com.university.uch_university.repository;

import com.university.uch_university.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
}
