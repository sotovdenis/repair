package com.example.repairs.repositories;

import com.example.repairs.entities.RepairParts;
import com.example.repairs.repositories.base.CreateRepo;
import com.example.repairs.repositories.base.ReadRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairPartsRepo extends CreateRepo<RepairParts>, ReadRepo<RepairParts> {
}
