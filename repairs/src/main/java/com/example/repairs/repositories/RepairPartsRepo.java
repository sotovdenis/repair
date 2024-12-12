package com.example.repairs.repositories;

import com.example.repairs.dto.TopDto;
import com.example.repairs.entities.Category;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.repositories.base.CreateRepo;
import com.example.repairs.repositories.base.ReadRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairPartsRepo extends CreateRepo<RepairParts>, ReadRepo<RepairParts> {
	List<RepairParts> getByCategoryName(String categoryName);
	List<TopDto> topFive();
	RepairParts findByName(String name);
}
