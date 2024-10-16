package web.dao;

import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
            entityManager.remove(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public Optional<User> findById(Long id) {
        User user = null;
        user = entityManager.find(User.class, id);

        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getUsers() {
        List<User> users = null;
        users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }

}
