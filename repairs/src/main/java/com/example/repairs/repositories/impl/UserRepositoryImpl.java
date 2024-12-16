package com.example.repairs.repositories.impl;

import com.example.repairs.entities.User;
import com.example.repairs.repositories.UserRepository;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends BaseCRUDRepo<User> implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(em.createQuery("SELECT u FROM User u WHERE u.username = :username",
                User.class).setParameter("username", username).getSingleResult());
    }

    @Override
    public User getUserByUsername(String param) {
        return em.createQuery("SELECT u FROM User u WHERE u.username = :username",
                User.class).setParameter("username", param).getSingleResult();
    }

    @Override
    public void saveAll(List<User> users) {
        for (User user : users) {
            em.persist(user);
        }
    }

    @Override
    public Optional<User> findOptionalByUsername(String username) {
        return Optional.of(em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class).
                setParameter("username", username).getSingleResult());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();

        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    @Override
    public long count() {
        return em.createQuery("SELECT COUNT(u) FROM User u", Long.class).getSingleResult();
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
