package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    public void insert(User user);
    public void update(User user);
    public void delete(User user);
    public void deleteById(Long id);
    Optional<User> findById(Long id);
    List<User> getUsers();
}
