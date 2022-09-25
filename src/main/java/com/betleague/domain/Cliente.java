package com.betleague.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cedula")
//	@Size(min = 8, max = 10, message="La cedula debe contener entre 8 y 10 numeros")
	@Pattern(regexp = "[0-9]+", message="La cedula solo puede contener numeros")
	@NotNull
	private Long cedula;
	
	@Column(name = "nombre")
	@Pattern(regexp = "[a-zA-Z]+", message="El nombre solo puede contener letras")
	private String nombre;
	
	@Column(name = "apellidos")
	@Pattern(regexp = "[a-zA-Z]+", message="El apellido solo puede contener letras")
	private String apellidos;
	
	@Column(name = "telefono")
//	@Size(max = 10, message="El telefono no puede llevar mas de 10 numeros")
	@Pattern(regexp = "[0-9]+", message="El telefono solo puede contener numeros")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contra")
	private String contra;
	
	@Column(name = "foto", length = 800)
	private String foto;
	
	@Column(name = "rol")
	private String rol;
	
	@Column(name = "usuariocreador")
	private String usuarioCreador;
	
	@Column(name = "usuariomodificador")
	private String usuarioModificador;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;
	
	@Column(name = "estado")
	private String estado;
	
}
