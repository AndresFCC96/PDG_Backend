package com.betleague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betleague.domain.Direccion;
import com.betleague.dto.DireccionDTO;
import com.betleague.repository.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService{

	@Autowired
	private DireccionRepository direccionRepository;
	
	@Override
	public Direccion crearDireccion(DireccionDTO direccionDTO) throws Exception {

		if (direccionDTO == null) {
			throw new Exception("La direccion no puede ser nula");
		}
		
		if (direccionDTO.getDireccion().trim().equals(" ")) {
			throw new Exception("Debe introducir la direccion.");
		}
		
		if (direccionDTO.getDireccion().length() < 12) {
			throw new Exception("La direccion debe contener mas de 12 caracteres.");
		}
		
		if (direccionDTO.getEstado().trim().equals(" ")) {
			throw new Exception("El estado no puede estar vacio.");
		}
		
		Direccion direccion = new Direccion();
		
		direccion.setDireccion(direccionDTO.getDireccion());
		direccion.setCedulaCliente(direccionDTO.getCedulaCliente());
		direccion.setEstado(direccionDTO.getEstado());
		
		return direccionRepository.save(direccion);
	}

	@Override
	public List<Direccion> listarDireccionesPorCliente(Long cedulaCliente) throws Exception {
		if (cedulaCliente == null) {
			throw new Exception("La cedula no puede estar nula.");
		}
		
		List<Direccion> direcciones = direccionRepository.findByCedulaCliente(cedulaCliente);
		
		if (!direcciones.isEmpty()) {
			return direcciones;
		}else {
			throw new Exception("El cliente con cedula " + cedulaCliente + " no tiene direcciones creadas.");
		}
	}

	@Override
	public Direccion modificarDireccion(DireccionDTO direccionDTO) throws Exception {
		
		if (direccionDTO == null) {
			throw new Exception("La direccion no puede ser nula");
		}
		
		if (direccionDTO.getIdDireccion() == null) {
			throw new Exception("El id de la direccion no puede ser nula");
		}
		
		if (direccionDTO.getDireccion().trim().equals(" ")) {
			throw new Exception("Debe introducir la direccion.");
		}
		
		if (direccionDTO.getDireccion().length() < 12) {
			throw new Exception("La direccion debe contener mas de 12 caracteres.");
		}
		
		if (direccionDTO.getEstado().trim().equals(" ")) {
			throw new Exception("El estado no puede estar vacio.");
		}
		
		Optional<Direccion> direccion = direccionRepository.findById(direccionDTO.getIdDireccion());
		
		Direccion direccionNueva = new Direccion();
		
		if(direccion.isPresent()) {
			direccionNueva = direccion.get();
		}else {
			throw new Exception("No existe ninguna direccion con ese id.");
		}
		
		direccionNueva.setIdDireccion(direccionDTO.getIdDireccion());
		direccionNueva.setDireccion(direccionDTO.getDireccion());
		direccionNueva.setCedulaCliente(direccionDTO.getCedulaCliente());
		direccionNueva.setEstado(direccionDTO.getEstado());
		
		return direccionRepository.save(direccionNueva);
	}

	@Override
	public void eliminarDireccion(DireccionDTO direccionDTO) throws Exception {
		if (direccionDTO == null) {
			throw new Exception("La direccion no puede ser nula");
		}
		
		if (direccionDTO.getIdDireccion() == null) {
			throw new Exception("El id de la direccion no puede ser nula");
		}
		
		
		direccionRepository.deleteById(direccionDTO.getIdDireccion());
	}

}
