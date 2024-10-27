package com.example.repairs.repositories.base;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteRepo<E> {
    void delete(E e);
}
