package com.example.repairs.repositories;

import com.example.repairs.entities.CarsInfo;
import com.example.repairs.repositories.base.CreateRepo;
import com.example.repairs.repositories.base.ReadRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInfoRepo extends CreateRepo<CarsInfo>, ReadRepo<CarsInfo> {
}
