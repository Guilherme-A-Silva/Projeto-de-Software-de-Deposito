package com.ControleDeposito.controle;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ControleDeposito.domain.model.Produto;

@RestController
public class ClienteControle {
	
	@GetMapping("/produtos")
	public List<Produto> Listar() {
		
		Produto produto1 = new Produto();
		produto1.setCodigo(123L);
		produto1.setDescricao("Descricao");
		produto1.setNome("Pizza");
		produto1.setQuantidade(5L);
		
		return Arrays.asList(produto1);
	}
}
