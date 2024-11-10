package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.dto.CarDto;
import com.example.repairs.entities.CarsInfo;
import com.example.repairs.repositories.CarInfoRepo;
import com.example.repairs.services.CarsInfoService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsInfoServiceImpl implements CarsInfoService {

    private CarInfoRepo carInfoRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    @Autowired
    public CarsInfoServiceImpl(CarInfoRepo carInfoRepo, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carInfoRepo = carInfoRepo;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addCarInfo(String brand, String vin) {
        CarDto carDto = new CarDto();
        carDto.setBrandName(brand);
        carDto.setVIN(vin);
        if (!this.validationUtil.isValid(carDto)) {
            this.validationUtil.violations(carDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            this.carInfoRepo.save(this.modelMapper.map(carDto, CarsInfo.class));
        }
    }

    @Override
    public List<CarsInfo> findCarInfoByName(String name) {
        return carInfoRepo.findByName(name);
    }

    @Override
    public List<CarsInfo> findAll() {
        return carInfoRepo.findAll();
    }
}
