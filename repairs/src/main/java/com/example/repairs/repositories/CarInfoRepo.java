package com.example.repairs.repositories;

import com.example.repairs.entities.CarsInfo;
import com.example.repairs.repositories.base.CreateRepo;
import com.example.repairs.repositories.base.ReadRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarInfoRepo extends CreateRepo<CarsInfo>, ReadRepo<CarsInfo> {
    List<CarsInfo> findByName(String name);
    List<CarsInfo> findByVin(String vin);
}
