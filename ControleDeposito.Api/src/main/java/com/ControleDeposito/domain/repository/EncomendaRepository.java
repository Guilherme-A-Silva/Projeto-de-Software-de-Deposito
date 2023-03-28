package com.ControleDeposito.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeposito.domain.model.Encomenda;


public interface EncomendaRepository extends JpaRepository<Encomenda, Long>{

	Optional<Encomenda> findByNome(String nome);
}
