package com.example.repairs.repositories;

import com.example.repairs.entities.Order;
import com.example.repairs.repositories.base.CreateRepo;
import com.example.repairs.repositories.base.ReadRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CreateRepo<Order>, ReadRepo<Order> {
}
