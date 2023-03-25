package com.ControleDeposito.api.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ControleDeposito.domain.model.Produto;
import com.ControleDeposito.domain.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoControle {
	
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> Listar() {
	
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> Buscar(@PathVariable Long codigo) {
	
		return produtoRepository.findById(codigo)
				.map(produto -> ResponseEntity.ok(produto))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Produto Adicionar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{codigo}") 
	public ResponseEntity<Produto> Atualizar(@PathVariable Long codigo, @RequestBody Produto produto){
		if(!produtoRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		produto.setCodigo(codigo);
		produto = produtoRepository.save(produto);
		
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/{codigo}") 
	public ResponseEntity<Void> Remover(@PathVariable Long codigo){
		if(!produtoRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		produtoRepository.deleteById(codigo);
		
		return ResponseEntity.noContent().build();
	}
}
