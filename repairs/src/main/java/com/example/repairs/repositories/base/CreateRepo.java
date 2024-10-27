package com.example.repairs.repositories.base;

import org.springframework.stereotype.Repository;

@Repository
public interface CreateRepo<E> {
    void save(E e);
}
