package com.example.repairs.services;

import com.example.repairs.dto.CarDto;
import com.example.repairs.entities.CarsInfo;

import java.util.List;

public interface CarsInfoService {
    void addCarInfo(String brand, String vin);
    List<CarsInfo> findCarInfoByName(String name);
    List<CarsInfo> findAll();
}
