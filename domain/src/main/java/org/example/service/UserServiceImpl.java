package org.example.service;

import org.example.entity.User;
import org.example.port.UserRepo;
import org.example.port.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(String name) {
        User user = new User(name);
        try {
            this.userRepo.save(user);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
       return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(int userId) {
        return userRepo.findById(userId);
    }

    @Override
    public void deleteUser(int userId) {

        userRepo.deleteById(userId);
    }

    @Override
    public User updateUser(int userId, User user) {
        userRepo.findById(userId);
        if (userId > 0) {
            try {
                user.setName(user.getName());
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
       return userRepo.save(user);
    }

    @Override
    public User getUserByUserNameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        return Optional.empty();
    }
}
