package com.devsuperior.dsdeliver.controllers;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dsdeliver.dtos.OrderDto;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<OrderDto>> getOrders() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getOrders());
	}

	@PostMapping
	public ResponseEntity<OrderDto> insert(@RequestBody OrderDto dto) {
		/*
		 * URI uri = ServletUriComponentsBuilder .fromCurrentContextPath().path("{id}")
		 * .buildAndExpand(dto.getId()).toUri(); return
		 * ResponseEntity.created(uri).body(service.insert(dto));
		 */
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
	}
}
