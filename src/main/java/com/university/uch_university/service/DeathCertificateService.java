package com.university.uch_university.service;

import com.university.uch_university.model.DeathCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class DeathCertificateService extends BaseService<DeathCertificate, UUID>  {
    @Autowired
    public DeathCertificateService(JpaRepository<DeathCertificate, UUID> repository) {
        super(repository);
    }
}