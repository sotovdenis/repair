package com.example.repairs.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {

    @Bean
    public Validator validator() {
        return Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
