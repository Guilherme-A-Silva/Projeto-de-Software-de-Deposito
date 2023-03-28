package com.ControleDeposito.api.controle;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	
	@GetMapping("id/{codigo}")
	public ResponseEntity<Produto> BuscarPorId(@PathVariable Long codigo) {
	
		return produtoRepository.findById(codigo)
				.map(produto -> ResponseEntity.ok(produto))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("nome/{nome}")
	public ResponseEntity<Produto> BuscarPorNome(@PathVariable String nome) {
		
		return produtoRepository.findByNome(nome)
				.map(produto -> ResponseEntity.ok(produto))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Produto Adicionar(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{codigo}") 
	public ResponseEntity<Produto> AtualizarTodosOsValoresPorId(@PathVariable Long codigo,@Valid @RequestBody Produto produto){
		if(!produtoRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		produto.setCodigo(codigo);
		produto = produtoRepository.save(produto);
		
		return ResponseEntity.ok(produto);
	}
	
	@PutMapping("qt/{codigo}/{quantidade}") 
	public ResponseEntity<Produto> AtualizarQuantidadePorId(@PathVariable Long codigo,@Valid Produto produto, 
			@PathVariable Long quantidade){
		if(!produtoRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		Optional<Produto> G = produtoRepository.findById(codigo);
		
		Produto X = G.get();
		
		produto.setCodigo(codigo);
		produto.setQuantidade(quantidade);
		produto.setDescricao(X.getDescricao());
		produto.setNome(X.getNome());
		produto.setPreco(X.getPreco());
		
		produto = produtoRepository.save(produto);
		
		return ResponseEntity.ok(produto);
	}
	
	@PutMapping("no/{codigo}/{nome}") 
	public ResponseEntity<Produto> AtualizarNomePorId(@PathVariable Long codigo,@Valid Produto produto, @PathVariable String nome){
		if(!produtoRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		Optional<Produto> G = produtoRepository.findById(codigo);
		
		Produto X = G.get();
		
		produto.setCodigo(codigo);
		produto.setNome(nome);
		produto.setDescricao(X.getDescricao());
		produto.setQuantidade(X.getQuantidade());
		produto.setPreco(X.getPreco());
		
		produto = produtoRepository.save(produto);
		
		return ResponseEntity.ok(produto);
	}
	
	@PutMapping("des/{codigo}/{descricao}") 
	public ResponseEntity<Produto> AtualizarDescricaoPorId(@PathVariable Long codigo,@Valid Produto produto, @PathVariable String descricao){
		if(!produtoRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		Optional<Produto> G = produtoRepository.findById(codigo);
		
		Produto X = G.get();
		
		produto.setCodigo(codigo);
		produto.setDescricao(descricao);
		produto.setNome(X.getNome());
		produto.setPreco(X.getPreco());
		produto.setQuantidade(X.getQuantidade());
		
		produto = produtoRepository.save(produto);
		
		return ResponseEntity.ok(produto);
	}
	
	@PutMapping("pre/{codigo}/{preco}") 
	public ResponseEntity<Produto> AtualizarPrecoPorId(@PathVariable Long codigo,@Valid Produto produto, @PathVariable Double preco){
		if(!produtoRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}

		Optional<Produto> G = produtoRepository.findById(codigo);
		
		Produto X = G.get();
		
		produto.setCodigo(codigo);
		produto.setPreco(preco);
		produto.setDescricao(X.getDescricao());
		produto.setNome(X.getNome());
		produto.setQuantidade(X.getQuantidade());
		
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
