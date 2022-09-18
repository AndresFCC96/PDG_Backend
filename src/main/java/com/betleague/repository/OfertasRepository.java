package com.betleague.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betleague.domain.Ofertas;
import com.betleague.dto.ClienteDTO;
import com.betleague.dto.ProductoDTO;

public interface OfertasRepository extends JpaRepository<Ofertas, Long>{
	
	List<Ofertas> findByCliente(ClienteDTO cliente);
	
	List<Ofertas> findByProducto(ProductoDTO producto);
}
