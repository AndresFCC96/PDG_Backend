package com.betleague.service;

import java.util.List;

import com.betleague.domain.Cliente;
import com.betleague.domain.Ofertas;
import com.betleague.domain.Producto;
import com.betleague.dto.ClienteDTO;
import com.betleague.dto.OfertasDTO;
import com.betleague.dto.ProductoDTO;

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
	List<Ofertas> encontrarTodasLasOfertasPorProducto(ProductoDTO producto) throws Exception;
	
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
}
