package com.ControleDeposito.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Produto {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long Codigo;
	
	private String Nome;
	private Long Quantidade;
	
}
