package org.example.port;

import org.example.entity.User;
import java.util.List;

public interface UserService {

    User createUser(String name);
    List<User> getAllUsers();
    User findUserById(int userId);
    void deleteUser(int userId);
    User updateUser(int userId, User user);
}
