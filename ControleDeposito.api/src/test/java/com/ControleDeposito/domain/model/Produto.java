package com.ControleDeposito.domain.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Codigo;
	@NotBlank
	private String Nome;
	@NotBlank
	private String Descricao;
	@NotBlank
	private long Quantidade;
}
