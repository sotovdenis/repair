package com.example.repairs.repositories;

import com.example.repairs.entities.Cart;
import com.example.repairs.repositories.base.CreateRepo;
import com.example.repairs.repositories.base.DeleteRepo;
import com.example.repairs.repositories.base.ReadRepo;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepo extends CreateRepo<Cart>, ReadRepo<Cart>, DeleteRepo<Cart> {
}
