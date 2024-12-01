package com.example.repairs.repositories.impl;

import com.example.repairs.entities.CarsInfo;
import com.example.repairs.repositories.CarInfoRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarInfoRepositoryImpl extends BaseCRUDRepo<CarsInfo> implements CarInfoRepo {

    public CarInfoRepositoryImpl() {
        super(CarsInfo.class);
    }

    @Override
    public List<CarsInfo> findByName(String name) {
        String jpql = "SELECT c FROM CarsInfo c WHERE c.brandName = :brand";
        TypedQuery<CarsInfo> query = super.getEntityManager().createQuery(jpql, CarsInfo.class);
        query.setParameter("brand", name);
        return query.getResultList();
    }

    @Override
    public List<CarsInfo> findByVin(String vin) {
        String jpql = "SELECT c FROM CarsInfo c WHERE c.vin = :vin";
        TypedQuery<CarsInfo> query = super.getEntityManager().createQuery(jpql, CarsInfo.class);
        query.setParameter("vin", vin);
        return query.getResultList();
    }
}
