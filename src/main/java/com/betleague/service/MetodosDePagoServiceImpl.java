package com.betleague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betleague.domain.MetodoDePago;
import com.betleague.dto.MetodoDePagoDTO;
import com.betleague.repository.MetodosDePagoRepository;

@Service
public class MetodosDePagoServiceImpl implements MetodosDePagoService{
	
	@Autowired
	MetodosDePagoRepository metodosRepository;
	
	@Override
	public List<MetodoDePago> obtenerLosMetodosDePagoPorCliente(Long cedula) throws Exception {
		if (cedula == null) {
			throw new Exception("La cedula no puede estar vacia.");
		}
		
		List<MetodoDePago> metodoDePagoABuscar = metodosRepository.findByIdCliente(cedula);
		
		if (!metodoDePagoABuscar.isEmpty()) {
			return metodoDePagoABuscar;
		}else {
			throw new Exception("El cliente con cedula " + cedula + " no tiene ningun metodo de pago inscrito" );
		}
	}

	@Override
	public MetodoDePago modificarMetodoDePago(MetodoDePagoDTO metodoDePagoDTO) throws Exception {
		if (metodoDePagoDTO == null) {
			throw new Exception("El metodo de pago no puede estar vacio.");
		}
		
		if (metodoDePagoDTO.getIdCliente() == null) {
			throw new Exception("La cedula no puede estar vacia.");
		}
		
		if (metodoDePagoDTO.getNumeroTarjeta().trim().equals("")) {
			throw new Exception("El numero de tarjeta no puede estar vacio.");
		}
		
		if (metodoDePagoDTO.getNombre() == null) {
			throw new Exception("El nombre del propietario de la tarjeta no puede estar vacio.");
		}
		
		if (metodoDePagoDTO.getMes() == null) {
			throw new Exception("El mes no puede estar vacio.");
		}
		
		
		if (metodoDePagoDTO.getYear() == null) {
			throw new Exception("El año no puede estar vacio.");
		}
		
		
		if (metodoDePagoDTO.getCcv() == null) {
			throw new Exception("Falta el ccv.");
		}
		
		if (metodoDePagoDTO.getYear().toString().length() > 3 || metodoDePagoDTO.getYear().toString().length() < 3) {
			throw new Exception("El CCV no puede tener mas o menos de 3 caracteres.");
		}
		
		Optional<MetodoDePago> metodoDePagoAEncontrar = metodosRepository.findByNumeroTarjeta(metodoDePagoDTO.getNumeroTarjeta());
		
		MetodoDePago metodoDePagoModificacion = metodoDePagoAEncontrar.get();
		
		metodoDePagoModificacion.setIdCliente(metodoDePagoDTO.getIdCliente());
		metodoDePagoModificacion.setNumeroTarjeta(metodoDePagoDTO.getNumeroTarjeta().replaceAll(" ", ""));
		metodoDePagoModificacion.setNombre(metodoDePagoDTO.getNombre());
		metodoDePagoModificacion.setMes(metodoDePagoDTO.getMes());
		metodoDePagoModificacion.setYear(metodoDePagoDTO.getYear());
		metodoDePagoModificacion.setCcv(metodoDePagoDTO.getCcv());
		
		return metodosRepository.save(metodoDePagoModificacion);
		
	}

	@Override
	public void eliminarMetodoDePago(Long numeroTarjeta) throws Exception {
		
		if (numeroTarjeta == null) {
			throw new Exception("El metodo de pago no puede estar vacio.");
		}
	
		
		metodosRepository.deleteById(numeroTarjeta);
		
	}

	@Override
	public MetodoDePago guardarMetodoDePago(MetodoDePagoDTO metodoDePagoDTO) throws Exception {
		if (metodoDePagoDTO == null) {
			throw new Exception("El metodo de pago no puede estar vacio.");
		}

		if (metodoDePagoDTO.getIdCliente() == null) {
			throw new Exception("La cedula no puede estar vacia.");
		}
		
		if (metodoDePagoDTO.getNumeroTarjeta() == null) {
			throw new Exception("El numero de tarjeta no puede estar vacio.");
		}
		
		if (metodoDePagoDTO.getNumeroTarjeta().replaceAll(" ", "").length() > 16 || metodoDePagoDTO.getNumeroTarjeta().replaceAll(" ", "").length() < 16) {
			throw new Exception("El numero de tarjeta no puede tener mas o menos de 16 caracteres.");
		}
		
		if (metodoDePagoDTO.getMes() == null) {
			throw new Exception("El mes no puede estar vacio.");
		}
		
		
		if (metodoDePagoDTO.getYear() == null) {
			throw new Exception("El año no puede estar vacio.");
		}
		
		
		if (metodoDePagoDTO.getCcv() == null) {
			throw new Exception("Falta el ccv.");
		}
		
		if (metodoDePagoDTO.getCcv().toString().length() > 3 || metodoDePagoDTO.getCcv().toString().length() < 3) {
			throw new Exception("El CCV no puede tener mas o menos de 3 caracteres.");
		}
		
		Optional<MetodoDePago> metodoDePagoAEncontrar = metodosRepository.findByNumeroTarjeta(metodoDePagoDTO.getNumeroTarjeta());
		
		MetodoDePago metodoDePagoGuardar = new MetodoDePago();
		
		if (metodoDePagoAEncontrar.isEmpty()) {
			metodoDePagoGuardar.setIdCliente(metodoDePagoDTO.getIdCliente());
			metodoDePagoGuardar.setNumeroTarjeta(metodoDePagoDTO.getNumeroTarjeta().replaceAll(" ", ""));
			metodoDePagoGuardar.setNombre(metodoDePagoDTO.getNombre());
			metodoDePagoGuardar.setMes(metodoDePagoDTO.getMes());
			metodoDePagoGuardar.setYear(metodoDePagoDTO.getYear());
			metodoDePagoGuardar.setCcv(metodoDePagoDTO.getCcv());
			return metodosRepository.save(metodoDePagoGuardar);
		}else {
			throw new Exception("Ya existe un metodo de pago con ese numero.");
		}
		

		
		
	}

}
