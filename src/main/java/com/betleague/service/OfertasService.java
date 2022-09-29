package com.betleague.service;

import java.util.List;

import com.betleague.domain.Ofertas;
import com.betleague.dto.ClienteDTO;
import com.betleague.dto.OfertasDTO;

public interface OfertasService {
	
	/**
	 * 
	 * @param cliente
	 * @return Una lista de ofertas por cliente
	 * @throws Exception
	 */
	List<Ofertas> encontrarTodasLasOfertasPorCliente(ClienteDTO cliente) throws Exception;
	
	/**
	 * 
	 * @param producto
	 * @return Una lista de ofertas por producto
	 * @throws Exception
	 */
	List<Ofertas> encontrarTodasLasOfertasPorProducto(Long id) throws Exception;
	
	/**
	 * 
	 * @param cliente
	 * @param producto
	 * @return Guarda una oferta
	 * @throws Exception
	 */
	Ofertas guardarOferta(OfertasDTO oferta) throws Exception;
	
	/**
	 * 
	 * @param cliente
	 * @param producto
	 * @return Modifica una oferta
	 * @throws Exception
	 */
	Ofertas modificarOferta(OfertasDTO oferta) throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	Ofertas encontrarLaOfertaMasAlta(Long id) throws Exception;
}
