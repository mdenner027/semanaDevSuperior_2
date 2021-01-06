package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsdeliver.dtos.OrderDto;
import com.devsuperior.dsdeliver.enums.OrderStatus;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	public List<OrderDto> getOrders() {
		return repo.findByStatusOrderByMomentAsc(OrderStatus.PENDING).stream().map(x -> new OrderDto(x))
				.collect(Collectors.toList());
	}
}
