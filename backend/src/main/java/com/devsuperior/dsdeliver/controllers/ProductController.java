package com.devsuperior.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdeliver.dtos.ProductDto;
import com.devsuperior.dsdeliver.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/products")
@Api(value = "/products", tags = "Products Endpoint")
public class ProductController {

	@Autowired
	private ProductService service;

	@ApiOperation(
			value = "Lista todos os produtos cadastrados ordenados pelo nome.",
			code = 200,
			httpMethod = "GET",
			response = ProductDto.class,
			responseContainer = "List"
			)
	@GetMapping
	public ResponseEntity<List<ProductDto>> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}
