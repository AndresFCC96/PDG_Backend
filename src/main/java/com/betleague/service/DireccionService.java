package com.betleague.service;

import java.util.List;

import com.betleague.domain.Direccion;
import com.betleague.dto.DireccionDTO;

public interface DireccionService {
	
	/**
	 * 
	 * @param direccionDTO
	 * @return
	 * @throws Exception
	 */
	public Direccion crearDireccion(DireccionDTO direccionDTO) throws Exception;

	/**
	 * 
	 * @param cedulaCliente
	 * @return
	 * @throws Exception
	 */
	public List<Direccion> listarDireccionesPorCliente(Long cedulaCliente) throws Exception;
	
	/**
	 * 
	 * @param direccionDTO
	 * @return
	 * @throws Exception
	 */
	public Direccion modificarDireccion(DireccionDTO direccionDTO) throws Exception;
	
	/**
	 * 
	 * @param direccionDTO
	 * @return
	 * @throws Exception
	 */
	public void eliminarDireccion(DireccionDTO direccionDTO) throws Exception;
}
