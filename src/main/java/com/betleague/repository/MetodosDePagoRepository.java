package com.betleague.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betleague.domain.MetodoDePago;


public interface MetodosDePagoRepository extends JpaRepository<MetodoDePago, Long>{
	
	List<MetodoDePago> findByIdCliente(Long idCliente);
	
	Optional<MetodoDePago> findByNumeroTarjeta(String numeroTarjeta);
}
