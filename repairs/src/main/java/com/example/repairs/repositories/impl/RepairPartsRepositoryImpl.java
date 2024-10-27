package com.example.repairs.repositories.impl;

import com.example.repairs.entities.RepairParts;
import com.example.repairs.repositories.RepairPartsRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import org.springframework.stereotype.Repository;

@Repository
public class RepairPartsRepositoryImpl extends BaseCRUDRepo<RepairParts> implements RepairPartsRepo {
    public RepairPartsRepositoryImpl() {
        super(RepairParts.class);
    }
}
