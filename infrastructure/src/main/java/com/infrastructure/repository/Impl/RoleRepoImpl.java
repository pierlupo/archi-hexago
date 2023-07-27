package com.infrastructure.repository.Impl;


import com.infrastructure.entity.RoleEntity;
import com.infrastructure.repository.RoleEntityRepo;
import org.example.entity.Role;
import org.example.port.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class RoleRepoImpl implements RoleRepo {


    @Autowired
    private RoleEntityRepo roleEntityRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Role findByName(String name) {
        RoleEntity roleEntity = modelMapper.map(name, RoleEntity.class);
        return roleEntityRepo.findByName(name);
    }



}
