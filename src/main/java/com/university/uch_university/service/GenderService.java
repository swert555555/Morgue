package com.university.uch_university.service;

import com.university.uch_university.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class GenderService extends BaseService<Gender, UUID>  {
    @Autowired
    public GenderService(JpaRepository<Gender, UUID> repository) {
        super(repository);
    }
}