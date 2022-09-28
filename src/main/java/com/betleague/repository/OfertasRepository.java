package com.betleague.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betleague.domain.Ofertas;
import com.betleague.dto.ClienteDTO;
import com.betleague.dto.ProductoDTO;

@Repository
public interface OfertasRepository extends JpaRepository<Ofertas, Long>{
	
	List<Ofertas> findByProducto(ProductoDTO producto);
	
}
