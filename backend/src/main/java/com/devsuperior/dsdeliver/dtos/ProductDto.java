package com.devsuperior.dsdeliver.dtos;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(
			notes = "Identificador numérico do produto.",
			name = "id",
			dataType = "Long",
			example = "12",
			position = 1
			)
	private Long id;
	
	@ApiModelProperty(
			value = "Nome do produto.",
			name = "name",
			dataType = "String",
			example = "Lasanha de Frango.",
			position = 2
			)
	private String name;
	
	@ApiModelProperty(
			value = "Preço do produto.",
			name = "price",
			dataType = "Double",
			example = "22.30.",
			position = 3
			)
	private Double price;
	
	@ApiModelProperty(
			value = "Descrição do produto.",
			name = "description",
			dataType = "String",
			example = "Lasanha de frango e queijo (AVISO: contém glúten e lactose).",
			position = 4
			)
	private String description;
	
	@ApiModelProperty(
			value = "Uri da imagem do produto.",
			name = "imageUri",
			dataType = "String",
			example = "https://post.greatist.com/2020/02/322868_1100-1100x628.jpg.",
			position = 5
			)
	private String imageUri;
}
