package com.devsuperior.dsdeliver.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.enums.OrderStatus;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(
			notes = "Identificador numérico do pedido.",
			name = "id",
			dataType = "Long",
			example = "12",
			position = 1
			)
	private Long id;
	
	@ApiModelProperty(
			notes = "Endereço do cliente que realizou o pedido.",
			name = "address",
			dataType = "String",
			example = "Rua João Firmino Fonseca de Sá",
			position = 2
			)
	private String address;
	
	@ApiModelProperty(
			notes = "Latitude da localização do cliente que realizou o pedido.",
			name = "latitude",
			dataType = "Double",
			example = "-5.580633471411606",
			position = 3
			)
	private Double latitude;
	
	@ApiModelProperty(
			notes = "Longitude da localização do cliente que realizou o pedido.",
			name = "longitude",
			dataType = "Double",
			example = "39.580633471411606",
			position = 4
			)
	private Double longitude;
	
	@ApiModelProperty(
			notes = "Data e hora no qual o pedido foi realizado.",
			name = "moment",
			dataType = "Instant",
			example = "2021-01-01T09:00:00Z",
			accessMode = AccessMode.READ_ONLY,
			position = 4
			)
	private Instant moment;
	
	@ApiModelProperty(
			notes = "Status do pedido.",
			name = "status",
			dataType = "OrderStatus",
			example = "DELIVERED",
			allowableValues = "DELIVERED, PENDING",
			readOnly = true,
			position = 5
			)
	private OrderStatus status;
	
	@ApiModelProperty(
			notes = "Valor total do pedido.",
			name = "total",
			dataType = "double",
			example = "30.2",
			readOnly = true,
			position = 6
			)
	private Double total;

	@ApiModelProperty(
			notes = "Lista dos produtos contidos no pedido.",
			name = "products",
			dataType = "List<ProductDto>",
			position = 7
			)
	private List<ProductDto> products = new ArrayList<>();

	public OrderDto(Order entity) {
		super();
		id = entity.getId();
		address = entity.getAddress();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
		moment = entity.getMoment();
		status = entity.getStatus();
		total = entity.getTotal();
		products = entity.getProducts()
				.stream()
				.map(x -> new ModelMapper().map(x, ProductDto.class))
				.collect(Collectors.toList());
	}

}
