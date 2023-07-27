package com.infrastructure.repository;

import com.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepo extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUsernameAndPassword(String username, String password);
    UserEntity findByUsername(String username);
}
