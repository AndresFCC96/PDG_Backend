package com.betleague.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@NotNull
	private Long cedula;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contra")
	private String contra;
	
	@Column(name = "foto", length = 800)
	private String foto;
	
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
