package com.example.repairs.repositories.impl;

import com.example.repairs.dto.TopDto;
import com.example.repairs.entities.Category;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.repositories.RepairPartsRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairPartsRepositoryImpl extends BaseCRUDRepo<RepairParts> implements RepairPartsRepo {
	public RepairPartsRepositoryImpl() {
		super(RepairParts.class);
	}

	@Override
	public List<RepairParts> getByCategoryName(@Param("categoryName") String categoryName) {
		String jpql = "SELECT rp FROM RepairParts rp WHERE rp.category.name = :categoryName";
		TypedQuery<RepairParts> query = super.getEntityManager().createQuery(jpql, RepairParts.class);
		query.setParameter("categoryName", categoryName);

		return query.getResultList();
	}

	@Override
	public List<TopDto> topFive() {
		String jpql = "SELECT new com.example.repairs.dto.TopDto(rp.id, rp.name, SUM(o.amount)) " +
				"FROM Order o " +
				"JOIN o.repairParts rp " +
				"WHERE MONTH(o.date) = MONTH(CURRENT_DATE()) " +
				"AND YEAR(o.date) = YEAR(CURRENT_DATE()) " +
				"GROUP BY rp.id, rp.name " +
				"ORDER BY SUM(o.amount) DESC";

		TypedQuery<TopDto> query = super.getEntityManager().createQuery(jpql, TopDto.class);
		query.setMaxResults(5);

		return query.getResultList();
	}

	@Override
	public RepairParts findByName(@Param("name") String name) {
		String jpql = "SELECT rp FROM RepairParts rp WHERE rp.name = :name";
		TypedQuery<RepairParts> query = super.getEntityManager().createQuery(jpql, RepairParts.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}


}
