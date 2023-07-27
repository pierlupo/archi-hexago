package org.example.port;

import org.example.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(String name);

    List<User> getAllUsers();

    User findUserById(int userId);

    void deleteUser(int userId);

    User updateUser(int userId, User user);

    User getUserByUserNameAndPassword(String username, String password);

    User getUserByUserName(String username);

    User findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsernameOrEmail(String username, String email);
}
