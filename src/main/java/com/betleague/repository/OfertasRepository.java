package com.betleague.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betleague.domain.Ofertas;

@Repository
public interface OfertasRepository extends JpaRepository<Ofertas, Long>{
	
	List<Ofertas> findByProducto(Long producto);
	
	Ofertas findTopByProductoOrderByValorOfertaDesc(Long producto);
	
}
