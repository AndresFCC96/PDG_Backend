package com.betleague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betleague.domain.Cliente;
import com.betleague.domain.Ofertas;
import com.betleague.domain.Producto;
import com.betleague.dto.ClienteDTO;
import com.betleague.dto.OfertasDTO;
import com.betleague.dto.ProductoDTO;
import com.betleague.repository.OfertasRepository;

@Service
public class OfertasServiceImpl implements OfertasService{
	
	@Autowired
	private OfertasRepository ofertasRepository; 
	
	@Override
	public List<Ofertas> encontrarTodasLasOfertasPorCliente(ClienteDTO cliente) throws Exception {
		if (cliente == null) {
			throw new Exception("El cliente no puede ser nulo");
		}
		
		List<Ofertas> ofetasPorCliente = ofertasRepository.findByCliente(cliente);
		
		if (!ofetasPorCliente.isEmpty()) {
			return ofetasPorCliente;
		}else {
			throw new Exception("El cliente no tiene ofertas activas");
		}
	}

	@Override
	public List<Ofertas> encontrarTodasLasOfertasPorProducto(ProductoDTO producto) throws Exception {
		if (producto == null) {
			throw new Exception("El producto no puede ser nulo");
		}
		
		List<Ofertas> ofetasPorProducto = ofertasRepository.findByProducto(producto);
		
		if (!ofetasPorProducto.isEmpty()) {
			return ofetasPorProducto;
		}else {
			throw new Exception("El producto no tiene ofertas activas");
		}
	}

	@Override
	public Ofertas guardarOferta(OfertasDTO oferta) throws Exception {
		if (oferta == null) {
			throw new Exception("La oferta no puede ser nulo.");
		}
		
		if (oferta.getIdOferta() < 0) {
			throw new Exception("La oferta no puede ser menor a cero o estar vacia.");
		}
		
		if (oferta.getCliente() == null) {
			throw new Exception("El cliente no puede ser nulo.");
		}
		
		if (oferta.getProducto() == null) {
			throw new Exception("El producto no puede ser nulo.");
		}
		
		if (oferta.getValorOferta() < 0) {
			throw new Exception("El valor de la oferta no puede ser menor a cero o estar vacia.");
		}
		
		Ofertas ofertaAGuardar = new Ofertas();
		
		ofertaAGuardar.setIdOferta(oferta.getIdOferta());
		ofertaAGuardar.setCliente(oferta.getCliente());
		ofertaAGuardar.setProducto(oferta.getProducto());
		ofertaAGuardar.setValorOferta(oferta.getValorOferta());
		
		return ofertasRepository.save(ofertaAGuardar);
	}

	@Override
	public Ofertas modificarOferta(OfertasDTO ofertas) throws Exception {
		if (ofertas == null) {
			throw new Exception("La oferta no puede ser nulo.");
		}
		
		if (ofertas.getIdOferta() < 0) {
			throw new Exception("La oferta no puede ser menor a cero o estar vacia.");
		}
		
		if (ofertas.getCliente() == null) {
			throw new Exception("El cliente no puede ser nulo.");
		}
		
		if (ofertas.getProducto() == null) {
			throw new Exception("El producto no puede ser nulo.");
		}
		
		if (ofertas.getValorOferta() < 0) {
			throw new Exception("El valor de la oferta no puede ser menor a cero o estar vacia.");
		}
		
		Optional<Ofertas> ofertaABuscar = ofertasRepository.findById(ofertas.getIdOferta());
		
		Ofertas oferta = new Ofertas();
		
		if (ofertaABuscar.isEmpty()) {
			throw new Exception("No existe oferta con ese id");
		}
		
		
		return null;
	}

}
