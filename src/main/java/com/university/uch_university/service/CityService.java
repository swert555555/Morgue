package com.university.uch_university.service;

import com.university.uch_university.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CityService extends BaseService<City, UUID>  {
    @Autowired
    public CityService(JpaRepository<City, UUID> repository) {
        super(repository);
    }
}