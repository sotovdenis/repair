package com.example.repairs.repositories.impl;

import com.example.repairs.entities.CarsInfo;
import com.example.repairs.repositories.CarInfoRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import org.springframework.stereotype.Repository;

@Repository
public class CarInfoRepositoryImpl extends BaseCRUDRepo<CarsInfo> implements CarInfoRepo {

    public CarInfoRepositoryImpl() {
        super(CarsInfo.class);
    }

}
