package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.repositories.RepairPartsRepo;
import com.example.repairs.services.RepairPartsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairPartsServiceImpl implements RepairPartsService {
    private final RepairPartsRepo repairPartsRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public RepairPartsServiceImpl(RepairPartsRepo repairPartsRepo, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.repairPartsRepo = repairPartsRepo;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }
}
