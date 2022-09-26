package com.betleague.dto;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetodoDePagoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idCliente;
	private String numeroTarjeta;
	private String nombre; 
	private String mes; 
	private String year;
	private String ccv;
}
