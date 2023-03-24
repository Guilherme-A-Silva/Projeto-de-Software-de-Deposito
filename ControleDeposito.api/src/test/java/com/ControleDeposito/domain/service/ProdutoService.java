package com.ControleDeposito.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ControleDeposito.domain.exception.NegocioException;
import com.ControleDeposito.domain.model.Produto;
import com.ControleDeposito.domain.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository;
	
	
	public Produto buscar(Long Codigo) {
		return produtoRepository.findById(Codigo)
				.orElseThrow(() -> new NegocioException("Produto não encontrado"));
	}
	
	@Transactional
	public Produto salvar(Produto produto) {
		boolean codigoEmUso = produtoRepository.findByNome(produto.getNome())
				.stream()
				.anyMatch(produtoExistente -> !produtoExistente.equals(produto));
				
		if (codigoEmUso) {
			throw new NegocioException("Já existe um produto cadastrado com este email!");
		}
		
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		produtoRepository.deleteById(clienteId);
	}
	
}
