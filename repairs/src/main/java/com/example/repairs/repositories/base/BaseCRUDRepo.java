package com.example.repairs.repositories.base;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.server.UID;


public class BaseCRUDRepo<E> implements CreateRepo<E>, DeleteRepo<E>, ReadRepo<E>, UpdateRepo<E> {

    private final Class<E> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public BaseCRUDRepo(Class<E> entity) {
        this.entityClass = entity;
    }

    @Override
    @Transactional
    public void save(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public E findById(UID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    @Transactional
    public void delete(E entity) {
        entityManager.remove(entity);
    }

    @Override
    @Transactional
    public void update(E entity) {
        entityManager.merge(entity);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
