package com.example.repairs.rest;

import com.example.repairs.dto.CarDto;
import com.example.repairs.entities.CarsInfo;
import com.example.repairs.services.CarsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarInfoController {
    private final CarsInfoService carsInfoService;

    @Autowired
    public CarInfoController(CarsInfoService carsInfoService) {
        this.carsInfoService = carsInfoService;
    }

    @PostMapping("/add")
    void addCarInfo(@RequestBody CarDto carDto) {
        carsInfoService.addCarInfo(
                carDto.getBrandName(),
                carDto.getVin());
    }

    @GetMapping("/all")
    List<CarsInfo> findAllCarsInfo() {
        return carsInfoService.findAll();
    }

    @RequestMapping("/find/{name}")
    List<CarsInfo> findByName(@PathVariable String name) {
        return carsInfoService.findCarInfoByName(name);
    }

}
