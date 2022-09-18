package com.betleague.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betleague.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Optional<Cliente> findByEmail(String email);
	 
	Optional<Cliente> findByEmailAndContra(String email, String contra);
	
	Optional<Cliente> findByCedula(Long cedula);
}
