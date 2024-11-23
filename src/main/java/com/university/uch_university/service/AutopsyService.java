package com.university.uch_university.service;
import com.university.uch_university.model.Autopsy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AutopsyService extends BaseService<Autopsy, UUID>  {
    @Autowired
    public AutopsyService(JpaRepository<Autopsy, UUID> repository) {
        super(repository);
    }
}