package com.example.repairs.repositories;

import com.example.repairs.entities.Customer;
import com.example.repairs.repositories.base.CreateRepo;
import com.example.repairs.repositories.base.ReadRepo;
import com.example.repairs.repositories.base.UpdateRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CreateRepo<Customer>, ReadRepo<Customer>, UpdateRepo<Customer> {
    void doSomething();
}
