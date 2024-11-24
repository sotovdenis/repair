package com.example.repairs.contr;

import com.example.repairs.dto.CustomerDto;
import com.example.repairs.dto.RenameCustomerDto;
import com.example.repairs.entities.Customer;
import com.example.repairs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
    }

//    @PatchMapping("/rename")
//    void updateLogin(RenameCustomerDto renameCustomerDto) {
//        customerService.updateCustomerById(renameCustomerDto);
//    }

    @GetMapping("/all")
    List<Customer> findAllCustomers() {
        return customerService.findAll();
    }

}
