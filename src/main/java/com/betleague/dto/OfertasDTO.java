package com.betleague.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.betleague.domain.Cliente;
import com.betleague.domain.Ofertas;
import com.betleague.domain.Producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfertasDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idOferta;
	
	private Long clienteOferta;
	
	private String nombreClienteOferta;
	
	private Long clienteResponsable;
	
	private Long producto;
	
	private int valorOferta;
	
	private String estado;
}	
