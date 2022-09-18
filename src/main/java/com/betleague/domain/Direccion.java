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
@Table(name="direccion")
public class Direccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id_direccion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDireccion;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "cedula_cliente")
	private Long cedulaCliente;
	
	@Column(name = "estado")
	private String estado;
}
