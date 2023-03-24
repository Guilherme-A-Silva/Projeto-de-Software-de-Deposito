package com.ControleDeposito.api.controle;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.ControleDeposito.domain.repository.ProdutoRepository;
import com.ControleDeposito.domain.service.ProdutoService;
import com.algaworks.algalog.domain.model.Cliente;
import com.ControleDeposito.domain.model.Produto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoControle {
	
	private ProdutoRepository produtoRepository;
	private ProdutoService produtoService;
	
	public List<Produto> Listar(){
		return produtoRepository.findAll();
	}
	
    @GetMapping("/{Codigo}")
    public ResponseEntity<Produto> buscar(@PathVariable Long Codigo) {
        return produtoRepository.findById(Codigo)
        		.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());	
             
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar(@Valid @RequestBody Produto produto) {
    	return produtoService.salvar(produto);
    }
}
