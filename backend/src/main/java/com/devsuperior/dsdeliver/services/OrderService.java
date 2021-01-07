package com.devsuperior.dsdeliver.services;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Servlet;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dsdeliver.dtos.OrderDto;
import com.devsuperior.dsdeliver.dtos.ProductDto;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.enums.OrderStatus;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private ProductRepository productRepo;

	@Transactional(readOnly = true)
	public List<OrderDto> getOrders() {
		return repo.findByStatusOrderByMomentAsc(OrderStatus.PENDING).stream().map(x -> new OrderDto(x))
				.collect(Collectors.toList());
	}

	@Transactional
	public OrderDto insert(OrderDto dto) {
		ModelMapper mp = new ModelMapper();
		Order order = mp.map(dto, Order.class);
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.PENDING);
		for (ProductDto p : dto.getProducts()) {
			Product product = productRepo.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = repo.save(order);
		return mp.map(order, OrderDto.class);
	}
}
