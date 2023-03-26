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

import com.ControleDeposito.domain.model.Encomenda;
import com.ControleDeposito.domain.model.StatusEncomenda;
import com.ControleDeposito.domain.repository.EncomendaRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/encomendas")
public class EncomendaControle {
	
	private EncomendaRepository encomendaRepository;
	
	@GetMapping
	public List<Encomenda> Listar(){
		
		return encomendaRepository.findAll();
	}
	
	@GetMapping("id/{codigo}")
	public ResponseEntity<Encomenda> BuscarPorId(@PathVariable Long codigo) {
	
		return encomendaRepository.findById(codigo)
				.map(encomenda -> ResponseEntity.ok(encomenda))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("nome/{nome}")
	public ResponseEntity<Encomenda> BuscarPorNome(@PathVariable String nome) {
		
		return encomendaRepository.findByNome(nome)
				.map(produto -> ResponseEntity.ok(produto))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Encomenda Adicionar(@RequestBody Encomenda encomenda) {
		encomenda.setStatus(StatusEncomenda.PENDENTE);
		return encomendaRepository.save(encomenda);
	}
	
	@PutMapping("/{codigo}/Cancelar") 
	public ResponseEntity<Encomenda> AtualizarStatusPorIdCancelado(@PathVariable Long codigo, Encomenda encomenda){
		if(!encomendaRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		Optional<Encomenda> G = encomendaRepository.findById(codigo);
		
		Encomenda X = G.get();
		
		encomenda.setCodigo(codigo);
		encomenda.setDescricao(X.getDescricao());
		encomenda.setNome(X.getNome());
		encomenda.setQuantidade(X.getQuantidade());
		encomenda.setStatus(StatusEncomenda.CANCELADA);
		encomenda = encomendaRepository.save(encomenda);
		
		return ResponseEntity.ok(encomenda);
	}
	
	@PutMapping("/{codigo}/Finalizado") 
	public ResponseEntity<Encomenda> AtualizarStatusPorIdFinalizado(@PathVariable Long codigo, Encomenda encomenda){
		if(!encomendaRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		Optional<Encomenda> G = encomendaRepository.findById(codigo);
		
		Encomenda X = G.get();
		
		encomenda.setCodigo(codigo);
		encomenda.setDescricao(X.getDescricao());
		encomenda.setNome(X.getNome());
		encomenda.setQuantidade(X.getQuantidade());
		encomenda.setStatus(StatusEncomenda.FINALIZADA);
		
		encomenda = encomendaRepository.save(encomenda);
		
		return ResponseEntity.ok(encomenda);
	}
	@PutMapping("/{codigo}") 
	public ResponseEntity<Encomenda> AtualizarTodosOsValoresPorId(@PathVariable Long codigo, @RequestBody Encomenda encomenda){
		if(!encomendaRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		encomenda.setCodigo(codigo);
		encomenda = encomendaRepository.save(encomenda);
		
		return ResponseEntity.ok(encomenda);
	}
	
	@PutMapping("qt/{codigo}/{quantidade}") 
	public ResponseEntity<Encomenda> AtualizarQuantidadePorId(@PathVariable Long codigo, Encomenda encomenda, @PathVariable Long quantidade){
		if(!encomendaRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		Optional<Encomenda> G = encomendaRepository.findById(codigo);
		
		Encomenda X = G.get();
		
		encomenda.setCodigo(codigo);
		encomenda.setDescricao(X.getDescricao());
		encomenda.setNome(X.getNome());
		encomenda.setQuantidade(quantidade);
		encomenda = encomendaRepository.save(encomenda);
		
		return ResponseEntity.ok(encomenda);
	}
	
	@PutMapping("no/{codigo}/{nome}") 
	public ResponseEntity<Encomenda> AtualizarNomePorId(@PathVariable Long codigo, Encomenda encomenda, @PathVariable String nome){
		if(!encomendaRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		Optional<Encomenda> G = encomendaRepository.findById(codigo);
		
		Encomenda X = G.get();
		
		encomenda.setCodigo(codigo);
		encomenda.setDescricao(X.getDescricao());
		encomenda.setQuantidade(X.getQuantidade());
		encomenda.setNome(nome);
		encomenda = encomendaRepository.save(encomenda);
		
		return ResponseEntity.ok(encomenda);
	}
	
	@PutMapping("des/{codigo}/{descricao}") 
	public ResponseEntity<Encomenda> AtualizarDescricaoPorId(@PathVariable Long codigo, Encomenda encomenda, @PathVariable String descricao){
		if(!encomendaRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		encomenda.setCodigo(codigo);
		encomenda.setDescricao(descricao);
		encomenda = encomendaRepository.save(encomenda);
		
		return ResponseEntity.ok(encomenda);
	}
	
	@DeleteMapping("/{codigo}") 
	public ResponseEntity<Void> Remover(@PathVariable Long codigo){
		if(!encomendaRepository.existsById(codigo)) {
			return ResponseEntity.notFound().build();
		}
		
		encomendaRepository.deleteById(codigo);
		
		return ResponseEntity.noContent().build();
	}
}
