package com.example.repairs.repositories.base;

import org.springframework.stereotype.Repository;

@Repository
public interface UpdateRepo<E> {
    void update(E e);
}
