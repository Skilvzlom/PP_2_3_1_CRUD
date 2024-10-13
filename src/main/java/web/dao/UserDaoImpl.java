package web.dao;

import web.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(User user) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(user);
            entityManager.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    @Override
    public void update(User user) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(user);
            entityManager.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    @Override
    public void delete(User user) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(user);
            entityManager.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    public User findById(int id) {
        EntityTransaction tx = null;
        User user = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            user = entityManager.find(User.class, id);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        EntityTransaction tx = null;
        List<User> users = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            users = entityManager.createQuery("from User", User.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
        return users;
    }
}
