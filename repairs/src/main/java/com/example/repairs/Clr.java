package com.example.repairs;

import com.example.repairs.entities.Customer;
import com.example.repairs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Clr implements CommandLineRunner {

    @Autowired
    public CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        customerService.addCustomer(new Customer("name", "email", "phone", "login", "password"));
    }
}
