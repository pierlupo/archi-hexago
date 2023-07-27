package com.infrastructure.repository.Impl;

import com.infrastructure.entity.UserEntity;
import com.infrastructure.repository.UserEntityRepo;
import org.example.entity.User;
import org.example.port.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepoImpl implements UserRepo {

    @Autowired
    private UserEntityRepo userEntityRepo;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntityRepo.save(userEntity);
        return user;
    }

    @Override
    public User findById(int userId) {
        Optional<UserEntity> userEntityOptional = userEntityRepo.findById(userId);
        if(userEntityOptional.isPresent()) {
            return modelMapper.map(userEntityOptional.get(), User.class);
        }
        throw new RuntimeException("User Not found");
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userEntityRepo.findAll().forEach(u -> {
            users.add(modelMapper.map(u, User.class));
        });
        return users;
    }


    @Override
    public void deleteById(int userId) {

        userEntityRepo.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {

        UserEntity userEntity = null;
        if (user.getId() > 0) {
            userEntity = modelMapper.map(user, UserEntity.class);
            try {
                userEntity.setName(userEntity.getName());
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
        userEntityRepo.save(userEntity);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return modelMapper.map(
                userEntityRepo.findByUsername(username), User.class
        );
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return modelMapper.map(
                userEntityRepo.findByUsernameAndPassword(username, password), User.class
        );
    }
}
