package org.example.port;

import org.example.entity.User;

import java.util.List;

public interface UserRepo {

    User save(User user);
    User findById(int userId);
    List<User> findAll();
    void deleteById(int userId);
    User updateUser(User user);
}
