package com.university.uch_university.repository;

import com.university.uch_university.model.DeathCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeathCertificateRepository extends JpaRepository<DeathCertificate, UUID> {
}
