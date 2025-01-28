package com.university.uch_university.service;

import com.university.uch_university.model.ChangeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChangeTypeService extends BaseService<ChangeType, UUID> {
    @Autowired
    public ChangeTypeService(JpaRepository<ChangeType, UUID> repository) {
        super(repository);
    }
}
