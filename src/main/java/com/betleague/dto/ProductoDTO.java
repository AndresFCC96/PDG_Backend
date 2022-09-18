package com.betleague.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idproducto;
	private String nombre;
	private String autor;
	private String categoria;
	private Date fechaSubida;
	private String descripcion;
	private String foto;
	private String archivo;
	private Long valoracionAutor;
	private Long subastaIdsubasta;
	private String estado;
}
