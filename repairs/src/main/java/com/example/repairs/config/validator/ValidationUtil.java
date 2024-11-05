package com.example.repairs.config.validator;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {
    <E> boolean isValid(E object);
    <E> Set<ConstraintViolation<E>> violations(E object);

}
