package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void insert(User user);
    public void update(User user);
    public void delete(User user);
    User findById(int id);
    List<User> getUsers();
}
