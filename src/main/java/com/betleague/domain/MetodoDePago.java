package com.betleague.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "metodos_de_pago")
public class MetodoDePago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@Id
	@Column(name = "numero_tarjeta")
	private String numeroTarjeta;
	
	@Column(name = "nombre")
	private String nombre; 
	
	@Column(name = "mes")
	private Long mes; 
	
	@Column(name = "year")
	private Long year;
	
	@Column(name = "ccv")
	private Long ccv;

}
