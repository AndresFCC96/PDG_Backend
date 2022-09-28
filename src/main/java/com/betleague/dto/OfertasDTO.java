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
	
	private Cliente clienteOferta;
	
	private Cliente clienteResponsable;
	
	private Producto producto;
	
	private int valorOferta;
}	
