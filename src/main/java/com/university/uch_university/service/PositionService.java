package com.university.uch_university.service;

import com.university.uch_university.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PositionService extends BaseService<Position, UUID> {
    @Autowired
    public PositionService(JpaRepository<Position, UUID> repository) {
        super(repository);
    }
}
