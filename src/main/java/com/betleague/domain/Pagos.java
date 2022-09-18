package com.betleague.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pago")
public class Pagos implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idPagos")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPagos;
	
	@Column(name = "cedula")
	private Long cedula;
	
	@Column(name = "nombrePagador")
	private String nombrePagador;
	
	@Column(name = "referencia1")
	private String referencia1;
	
	@Column(name = "referencia2")
	private String referencia2;
}
