package com.university.uch_university.service;

import com.university.uch_university.model.CauseOfDeath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CauseOfDeathService extends BaseService<CauseOfDeath, UUID>  {
    @Autowired
    public CauseOfDeathService(JpaRepository<CauseOfDeath, UUID> repository) {
        super(repository);
    }
}