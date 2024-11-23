package com.university.uch_university.service;

import com.university.uch_university.model.Corpse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CorpseService extends BaseService<Corpse, UUID>  {
    @Autowired
    public CorpseService(JpaRepository<Corpse, UUID> repository) {
        super(repository);
    }
}