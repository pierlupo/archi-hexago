package org.example.port;

import org.example.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {

    User save(User user);

    User findById(int userId);

    List<User> findAll();

    void deleteById(int userId);

    User updateUser(User user);

    Boolean existsByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
