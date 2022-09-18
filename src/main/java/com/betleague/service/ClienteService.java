package com.betleague.service;

import java.util.List;

import com.betleague.domain.Cliente;
import com.betleague.dto.ClienteDTO;

public interface ClienteService {
	
	/**
	 * 
	 */
	public List<Cliente> consultarTodosLosCliente() throws Exception;
	/**
	 * 
	 * @param clienteDTO
	 * @throws Exception
	 */
	public void validarCliente(ClienteDTO clienteDTO) throws Exception;
	
	/**
	 * 
	 * @param clienteDTO
	 * @return
	 * @throws Exception
	 */
	public Cliente consultarCliente(ClienteDTO clienteDTO) throws Exception;
	
	/**
	 * 
	 * @param clienteDTO
	 * @return
	 * @throws Exception
	 */
	public Cliente guardarCliente(ClienteDTO clienteDTO) throws Exception;
	
	/**
	 * 
	 * @param clienteDTO
	 * @throws Exception
	 */
	public Cliente modificarCliente(ClienteDTO clienteDTO) throws Exception;
}
