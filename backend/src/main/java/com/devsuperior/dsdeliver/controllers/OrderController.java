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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/orders")
@Api(value = "/orders", tags = "Orders Endpoint")
public class OrderController {

	@Autowired
	private OrderService service;

	@ApiOperation(
			value = "Listar pedidos cadastrados",
			notes = "Lista os pedidos com o status PENDING (pendente) salvos na base de dados.",
			code = 200,
			httpMethod = "GET",
			response = OrderDto.class,
			responseContainer = "List"
			)
	@GetMapping
	public ResponseEntity<List<OrderDto>> getOrders() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getOrders());
	}

	
	@ApiOperation(
			value = "Cadastrar novo pedido",
			notes = "Cadastra um novo pedido na base de dados.",
			code = 201,
			httpMethod = "POST",
			response = OrderDto.class,
			consumes = "application/json"
			)
	@PostMapping
	public ResponseEntity<OrderDto> insert(@RequestBody OrderDto dto) {
		/*
		 * URI uri = ServletUriComponentsBuilder .fromCurrentContextPath().path("{id}")
		 * .buildAndExpand(dto.getId()).toUri(); return
		 * ResponseEntity.created(uri).body(service.insert(dto));
		 */
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
	}

	
	@ApiOperation(
			value = "Alterar status do pedido",
			notes = "Altera o status de um pedido de PENDING (pendendte) para DELIVERED (entregue)",
			code = 200,
			httpMethod = "PUT",
			response = OrderDto.class
			)
	@ApiParam(
			value = "Identificador numérico do pedido.",
			example = "2",
			type = "Long"
			)
	@PutMapping(value = "/{id}/delivered")
	public ResponseEntity<OrderDto> setDeliver(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.deliver(id));
	}
}
