package com.example.repairs.services;

import com.example.repairs.dto.RepairPartsDto;
import com.example.repairs.entities.RepairParts;

import java.util.List;

public interface RepairPartsService {
    void addRepairPart(RepairPartsDto repairPartsDto);
    List<RepairParts> findAll();
}
