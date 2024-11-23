package com.university.uch_university.repository;

import com.university.uch_university.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    UserModel findByUsername(String username);

    boolean existsByUsername(String username);
}
