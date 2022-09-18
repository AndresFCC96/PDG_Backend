package com.betleague.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betleague.domain.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{
	
	List<Direccion> findByCedulaCliente(Long cedula);

}
