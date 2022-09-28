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
@Table(name = "oferta")
public class Ofertas implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idOferta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOferta;
	
	@Column(name = "clienteoferta")
	private Cliente clienteOferta;
	
	@Column(name = "clienteresponsable")
	private Cliente clienteResponsable;
	
	@Column(name = "producto")
	private Producto producto;
	
	@Column(name = "valorOferta")
	private int valorOferta;

}
