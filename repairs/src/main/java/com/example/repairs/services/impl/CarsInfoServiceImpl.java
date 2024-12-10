package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.dto.CarDto;
import com.example.repairs.entities.CarsInfo;
import com.example.repairs.repositories.CarInfoRepo;
import com.example.repairs.services.CarsInfoService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
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
    @CacheEvict(cacheNames = "cars", allEntries = true)
    public void addCarInfo(String brand, String vin) {
        CarDto carDto = new CarDto();
        carDto.setBrandName(brand);
        carDto.setVin(vin);
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
    @Cacheable("cars")
    public List<CarsInfo> findCarInfoByName(String name) {
        return carInfoRepo.findByName(name);
    }

    @Override
    public List<CarsInfo> findAll() {
        return carInfoRepo.findAll();
    }
}
