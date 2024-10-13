package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    List<User> getUsers();

}
