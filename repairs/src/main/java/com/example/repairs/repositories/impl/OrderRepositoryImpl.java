package com.example.repairs.repositories.impl;

import com.example.repairs.entities.Order;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.repositories.OrderRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl extends BaseCRUDRepo<Order> implements OrderRepo {
	public OrderRepositoryImpl() {
		super(Order.class);
	}

	@Override
	public List<Order> getAllByUserId(String userId) {
		String jpql = "SELECT o FROM Order o WHERE o.user.id = :userId";
		TypedQuery<Order> query = super.getEntityManager().createQuery(jpql, Order.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
