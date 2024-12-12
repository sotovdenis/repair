package com.example.repairs.repositories.impl;

import com.example.repairs.entities.RepairParts;
import com.example.repairs.entities.Review;
import com.example.repairs.repositories.ReviewRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepositoryImpl extends BaseCRUDRepo<Review> implements ReviewRepo {
	public ReviewRepositoryImpl() {
		super(Review.class);
	}

	@Override
	public List<Review> getAllByRepairName(String repairName) {
		String jpql = "SELECT r FROM Review r WHERE r.repairParts.name = :repairName";
		TypedQuery<Review> query = super.getEntityManager().createQuery(jpql, Review.class);
		query.setParameter("repairName", repairName);

		return query.getResultList();
	}

	@Override
	public List<Review> findAllByRepairName(String name) {
		String jpql = "SELECT r FROM Review r WHERE r.repairParts.name = :name";
		TypedQuery<Review> query = super.getEntityManager().createQuery(jpql, Review.class);
		query.setParameter("name", name);

		return query.getResultList();
	}
}
