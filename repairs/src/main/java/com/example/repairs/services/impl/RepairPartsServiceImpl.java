package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.dto.RepairPartsDto;
import com.example.repairs.entities.Category;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.repositories.CategoryRepo;
import com.example.repairs.repositories.RepairPartsRepo;
import com.example.repairs.services.RepairPartsService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairPartsServiceImpl implements RepairPartsService {
	private final RepairPartsRepo repairPartsRepo;
	private final CategoryRepo categoryRepo;
	private final ValidationUtil validationUtil;
	private final ModelMapper modelMapper;

	@Autowired
	public RepairPartsServiceImpl(RepairPartsRepo repairPartsRepo, CategoryRepo categoryRepo, ValidationUtil validationUtil, ModelMapper modelMapper) {
		this.repairPartsRepo = repairPartsRepo;
		this.categoryRepo = categoryRepo;
		this.validationUtil = validationUtil;
		this.modelMapper = modelMapper;
	}

	@Override
	public void addRepairPart(RepairPartsDto repairPartsDto) {
		if (!this.validationUtil.isValid(repairPartsDto)) {
			this.validationUtil.violations(repairPartsDto)
					.stream()
					.map(ConstraintViolation::getMessage)
					.forEach(System.out::println);
		} else {
			Category category = categoryRepo.findById(repairPartsDto.getCategory());

			repairPartsDto.setCategory(category.getId());

			RepairParts repairParts = new RepairParts();
			repairParts.setCategory(category);
			repairParts.setName(repairPartsDto.getName());
			repairParts.setDescription(repairPartsDto.getDescription());
			repairParts.setPrice(repairPartsDto.getPrice());

			this.repairPartsRepo.save(repairParts);
		}
	}

	@Override
	public List<RepairParts> findAll() {
		return repairPartsRepo.findAll();
	}
}
