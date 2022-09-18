package com.betleague.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betleague.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	@Query("SELECT p FROM producto p WHERE LOWER(p.nombre) like LOWER(concat('%', :name,'%'))")
	List<Producto> findByNombre(String nombre);
	
	List<Producto> findByEstado(String estado);
	
	List<Producto> findByAutor(String autor);
}
