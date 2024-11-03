package com.example.repairs.repositories.base;

import com.example.repairs.entities.CarsInfo;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.util.List;

@Repository
public interface ReadRepo<E> {
    E findById(String uid);
    List<E> findAll();
}
