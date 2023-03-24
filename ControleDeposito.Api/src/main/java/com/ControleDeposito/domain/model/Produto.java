package com.ControleDeposito.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Produto {
	
	private Long Codigo;
	private String Nome;
	private String Descricao;
	private Long Quantidade;
	
}
