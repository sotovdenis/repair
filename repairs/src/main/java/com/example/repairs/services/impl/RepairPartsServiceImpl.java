package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.dto.CarDto;
import com.example.repairs.dto.RepairPartsDto;
import com.example.repairs.entities.CarsInfo;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.repositories.RepairPartsRepo;
import com.example.repairs.services.RepairPartsService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void addRepairPart(RepairPartsDto repairPartsDto) {
        if (!this.validationUtil.isValid(repairPartsDto)) {
            this.validationUtil.violations(repairPartsDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            this.repairPartsRepo.save(this.modelMapper.map(repairPartsDto, RepairParts.class));
        }
    }

    @Override
    public List<RepairParts> findAll() {
        return repairPartsRepo.findAll();
    }
}
