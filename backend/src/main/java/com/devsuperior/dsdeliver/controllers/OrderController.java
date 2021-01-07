package com.devsuperior.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdeliver.dtos.OrderDto;
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

	@PutMapping(value = "/{id}/delivered")
	public ResponseEntity<OrderDto> setDeliver(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.deliver(id));
	}
}
