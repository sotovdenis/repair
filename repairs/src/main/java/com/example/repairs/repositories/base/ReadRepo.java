package com.example.repairs.repositories.base;

import org.springframework.stereotype.Repository;

import java.rmi.server.UID;

@Repository
public interface ReadRepo<E> {
    E findById(UID uid);
}
