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
@Table(name = "subasta")
public class Subasta implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idSubasta")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSubasta;
	
	@Column(name = "producto", length = 40)
	private String producto;
	
	@Column(name = "numeroparticipantes")
	private Long numeroParticipantes;
	
	@Column(name = "numeromaximoparticipantes")
	private Long numeroMaximoParticipantes;
	
	@Column(name = "apuestamaxima")
	private Long apuestaMaxima;
	
	@Column(name = "apuestaminima")
	private Long apuestaMinima;
	
	@Column(name = "totalapuesta")
	private Long totalApuesta;
	
	@Column(name = "usuariocreador", length = 20)
	private String usuarioCreador;
	
	@Column(name = "usuariomodificador", length = 20)
	private String usuarioModificador;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;
	
	@Column(name = "estado", length = 1)
	private String estado;
}
