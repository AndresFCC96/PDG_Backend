package com.betleague.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idproducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idproducto;
	
	@Column(name = "nombre")
	@NotNull
	private String nombre;
	
	@Column(name = "autor", length = 40)
	private String autor;
	
	@Column(name = "categoria", length = 20)
	private String categoria;
	
	@Column(name = "fechasubida")
	private Date fechaSubida;
	
	@Column(name = "descripcion", length = 200)
	private String descripcion;
	
	@Column(name = "foto", length = 800)
	private String foto;
	
	@Column(name = "archivo", length = 800)
	private String archivo;
	
	@Column(name = "valoracionautor")
	private Long valoracionAutor;
	
	@Column(name = "subasta_idsubasta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subastaIdsubasta;
	
	@Column(name = "estado", length = 1)
	private String estado;
}	
