package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.dto.CustomerDto;
import com.example.repairs.dto.RenameCustomerDto;
import com.example.repairs.entities.Customer;
import com.example.repairs.repositories.CustomerRepo;
import com.example.repairs.services.CustomerService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCustomer(CustomerDto customer) {
        if (!this.validationUtil.isValid(customer)) {
            this.validationUtil.violations(customer)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            this.customerRepo.save(this.modelMapper.map(customer, Customer.class));
        }
    }

    @Override
    public void updateCustomerLoginById(RenameCustomerDto renameCustomerDto) {
        Customer customer = customerRepo.findById(renameCustomerDto.getId());
        customer.setLogin(renameCustomerDto.getNewLogin());
//        TODO: решить проблему id to load is required for loading
        customerRepo.update(customer);
    }

//    @Override
//    public void updateCustomerByLogin(String id, String newLogin) {
////        if (!this.validationUtil.isValid(customerDto)) {
////            this.validationUtil.violations(customerDto)
////                    .stream()
////                    .map(ConstraintViolation::getMessage)
////                    .forEach(System.out::println);
////        } else {
////            this.customerRepo.update(this.modelMapper.map(customerDto, Customer.class));
////        }
//
////        Customer customer = new Customer(customerDto.getName(), customerDto.getEmail(), customerDto.getPhone(), customerDto.getLogin(), customerDto.getPassword());
//
//        //TODO: add validation
//        Customer customer = customerRepo.findById(id);
//
//        customer.setLogin(newLogin);
//
//        customerRepo.update(customer);
//
//        //TODO: спросить по поводу методов обновления. Если реализуется аутентификация, то там всё иначе и зачем сейчас это писать........
//    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void updateCustomerById(String id, CustomerDto customerDto) {
        Customer customer = customerRepo.findById(id);
        customer.setLogin(customerDto.getLogin());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setPassword(customerDto.getPassword());
        customerRepo.update(customer);

    }

    @Override
    public CustomerDto getCustomerById(String id) {
        Customer customer = customerRepo.findById(id);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setPassword(customer.getPassword());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        customerDto.setLogin(customer.getLogin());
        customerDto.setName(customer.getName());

        return customerDto;
    }

}
