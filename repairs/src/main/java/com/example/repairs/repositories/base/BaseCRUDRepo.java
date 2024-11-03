package com.example.repairs.repositories.base;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.server.UID;
import java.util.List;
import java.util.Optional;


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
    public E findById(String id) {
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

    @Override
    public List<E> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<E> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
