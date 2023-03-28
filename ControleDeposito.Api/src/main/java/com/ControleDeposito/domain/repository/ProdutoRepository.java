package com.ControleDeposito.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeposito.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Optional<Produto> findByNome(String nome);
	
}
