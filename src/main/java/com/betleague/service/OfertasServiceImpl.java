package com.betleague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.betleague.domain.Cliente;
import com.betleague.domain.Ofertas;
import com.betleague.domain.Producto;
import com.betleague.dto.ClienteDTO;
import com.betleague.dto.OfertasDTO;
import com.betleague.dto.ProductoDTO;
import com.betleague.repository.OfertasRepository;
import com.betleague.repository.ProductoRepository;

@Service
public class OfertasServiceImpl implements OfertasService{
	
	@Autowired
	private OfertasRepository ofertasRepository; 
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Ofertas> encontrarTodasLasOfertasPorCliente(ClienteDTO cliente) throws Exception {
		if (cliente == null) {
			throw new Exception("El cliente no puede ser nulo");
		}
		
//		List<Ofertas> ofetasPorCliente = ofertasRepository.findByCliente(cliente);
		
//		if (!ofetasPorCliente.isEmpty()) {
//			return ofetasPorCliente;
//		}else {
//			throw new Exception("El cliente no tiene ofertas activas");
//		}
		return null;
	}

	@Override
	public List<Ofertas> encontrarTodasLasOfertasPorProducto(Long id) throws Exception {
		if (id == null) {
			throw new Exception("El producto no puede ser nulo");
		}
		
		Optional<Producto> producto = productoRepository.findById(id);
		
		List<Ofertas> ofetasPorProducto = ofertasRepository.findByProducto(producto.get().getIdproducto());
		
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
		
		if (oferta.getClienteResponsable() == null) {
			throw new Exception("El cliente no puede ser nulo.");
		}
		
		if (oferta.getProducto() == null) {
			throw new Exception("El producto no puede ser nulo.");
		}
		
		if (oferta.getValorOferta() < 0) {
			throw new Exception("El valor de la oferta no puede ser menor a cero o estar vacia.");
		}
		
		Ofertas ofertaAGuardar = new Ofertas();
		
		ofertaAGuardar.setClienteOferta(oferta.getClienteOferta());
		ofertaAGuardar.setNombreClienteOferta(oferta.getNombreClienteOferta());
		ofertaAGuardar.setClienteResponsable(oferta.getClienteResponsable());
		ofertaAGuardar.setProducto(oferta.getProducto());
		ofertaAGuardar.setValorOferta(oferta.getValorOferta());
		oferta.setEstado(oferta.getEstado());
		
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
		
		if (ofertas.getProducto() == null) {
			throw new Exception("El producto no puede ser nulo.");
		}
		
		if (ofertas.getValorOferta() < 0) {
			throw new Exception("El valor de la oferta no puede ser menor a cero o estar vacia.");
		}
		
		Optional<Ofertas> ofertaABuscar = ofertasRepository.findById(ofertas.getIdOferta());
		
		Ofertas oferta = new Ofertas();
		
		if (!ofertaABuscar.isPresent()) {
			throw new Exception("No existe oferta con ese id");
		}
		
		oferta.setIdOferta(ofertas.getIdOferta());
		oferta.setClienteOferta(ofertas.getClienteOferta());
		oferta.setNombreClienteOferta(ofertas.getNombreClienteOferta());
		oferta.setClienteResponsable(ofertas.getClienteResponsable());
		oferta.setProducto(ofertas.getProducto());
		oferta.setValorOferta(ofertas.getValorOferta());
		oferta.setEstado(ofertas.getEstado());
		
		return ofertasRepository.save(oferta);
		
	}

	@Override
	public Ofertas encontrarLaOfertaMasAlta(Long id) throws Exception {
		
		Ofertas oferta = ofertasRepository.findTopByProductoOrderByValorOfertaDesc(id);
		
		if (oferta != null) {
			return oferta;
		}else {
			throw new Exception("La oferta no tiene maximos");
		}
	}

}
