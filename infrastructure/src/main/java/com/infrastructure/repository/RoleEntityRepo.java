package com.infrastructure.repository;

import com.infrastructure.entity.RoleEntity;
import org.example.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityRepo extends CrudRepository<RoleEntity, Long> {

    Role findByName(String name);
}