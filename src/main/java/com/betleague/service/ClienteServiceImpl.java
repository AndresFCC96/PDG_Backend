package com.betleague.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betleague.domain.Cliente;
import com.betleague.dto.ClienteDTO;
import com.betleague.repository.ClienteRepository;
import com.betleague.utils.CONSTANTES;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente consultarCliente(ClienteDTO clienteDTO) throws Exception {

		validarCliente(clienteDTO);
		Optional<Cliente> cliente = clienteRepository.findByEmailAndContra(clienteDTO.getEmail(),
				clienteDTO.getContra());

		if (cliente.isPresent()) {
			System.out.println(cliente.get().getRol());
			return cliente.get();
		} else {
			throw new Exception("No se encontro ningun usuario con esos datos.");
		}
		

	}

	@Override
	@Transactional()
	public Cliente guardarCliente(ClienteDTO clienteDTO) throws Exception {

		validarCliente(clienteDTO);

		if (clienteDTO.getNombre().trim().equals("")) {
			throw new Exception("El nombre no puede estar vacio.");
		}
		
		if (clienteDTO.getApellidos().trim().equals("")) {
			throw new Exception("Los apellidos no puede estar vacio.");
		}

		if (clienteDTO.getEmail().trim().equals("")) {
			throw new Exception("El email no puede estar vacio.");
		}

		if (clienteDTO.getContra().trim().equals("")) {
			throw new Exception("La contraseña no puede estar vacia.");
		}

		if (clienteDTO.getCedula() == null) {
			throw new Exception("La cedula no puede estar vacia.");
		}
		
		Cliente cliente = new Cliente();

		cliente.setCedula(clienteDTO.getCedula());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setContra(clienteDTO.getContra());
		cliente.setFoto("Default");
		cliente.setTelefono(clienteDTO.getTelefono());
		cliente.setRol(clienteDTO.getRol());
		cliente.setFechaCreacion(new Date());
		cliente.setUsuarioCreador("ACAMPAZ");
		cliente.setEstado(CONSTANTES.ACTIVO);

		return clienteRepository.save(cliente);
	}

	@Override
	public void validarCliente(ClienteDTO clienteDTO) throws Exception {

		if (clienteDTO == null) {
			throw new Exception("El cliente no puede estar vacio.");
		}

		if (clienteDTO.getEmail().trim().equals("")) {
			throw new Exception("El email no puede estar vacio.");
		}

		if (clienteDTO.getEmail().length() < 4 && clienteDTO.getEmail().length() > 40) {
			throw new Exception("El email no puede contener menos de 20 caracteres ni mas de 40.");
		}

		if (!clienteDTO.getEmail().contains("@")) {
			throw new Exception("El email debe contener un arroba.");
		}

		if (!clienteDTO.getEmail().contains("com") && !clienteDTO.getEmail().contains("es")
				&& !clienteDTO.getEmail().contains("net")) {
			throw new Exception("El correo debe incluir e`l tipo, ej: .com, .net o .es.");
		}

		if (clienteDTO.getContra().trim().equals("")) {
			throw new Exception("La contraseña no puede estar vacia.");
		}

	}

	@Override
	public Cliente modificarCliente(ClienteDTO clienteDTO) throws Exception {

		if (clienteDTO == null) {
			throw new Exception("El cliente no puede estar vacio.");
		}
		
		if (clienteDTO.getContra().trim().equals("")) {
			throw new Exception("La contraseña no puede estar vacia.");
		}
		
		Optional<Cliente> clienteABuscar = clienteRepository.findByCedula(clienteDTO.getCedula());
		
		Cliente cliente = new Cliente();
		
		if (clienteABuscar.isPresent()) {
			cliente = clienteABuscar.get();
		}else {
			throw new Exception("El cliente a editar no existe");
		}
		
		cliente.setCedula(clienteDTO.getCedula());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setContra(clienteDTO.getContra());
		cliente.setFoto(clienteDTO.getFoto());
		cliente.setTelefono(clienteDTO.getTelefono());
		cliente.setRol(clienteDTO.getRol());
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());
		cliente.setUsuarioCreador(clienteDTO.getUsuarioCreador());
		cliente.setUsuarioModificador(clienteDTO.getUsuarioModificador());
		cliente.setFechaModificacion(new Date());
		cliente.setEstado(clienteDTO.getEstado());
		
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> consultarTodosLosCliente() throws Exception {
		
		List<Cliente> listaCliente = clienteRepository.findAll();
		
		if (!listaCliente.isEmpty()) {
			return listaCliente;
		}else {
			throw new Exception("No existen clientes en el momento");
		}
	}

}
