package com.example.repairs.rest;

import com.example.repairs.dto.RepairPartsDto;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.services.RepairPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repairs")
public class RepairPartsController {
    private final RepairPartsService repairPartsService;

    @Autowired
    public RepairPartsController(RepairPartsService repairPartsService) {
        this.repairPartsService = repairPartsService;
    }

    @PostMapping("/add")
    void addRepair(RepairPartsDto repairPartsDto) {
        repairPartsService.addRepairPart(repairPartsDto);
    }

    @GetMapping("/all")
    List<RepairParts> findAll() {
        return repairPartsService.findAll();
    }

}
