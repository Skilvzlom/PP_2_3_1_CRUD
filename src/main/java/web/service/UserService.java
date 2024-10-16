package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void insertUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    void deleteById(Long id);
    List<User> getUsers();
    Optional<User> getUserById(Long id);

}
