package com.betleague.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long cedula;
	private String nombre;
	private String apellidos;
	private String email;
	private String contra;
	private String foto;
	private String repetirContra;
	private String telefono;
	private String rol;
	private String usuarioCreador;
	private String usuarioModificador;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	
	
}
