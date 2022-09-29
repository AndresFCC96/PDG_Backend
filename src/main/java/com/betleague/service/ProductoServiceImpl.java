package com.betleague.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.betleague.domain.Producto;
import com.betleague.dto.ClienteDTO;
import com.betleague.dto.ProductoDTO;
import com.betleague.repository.ProductoRepository;
import com.betleague.utils.CONSTANTES;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository productoRepository;
	
	//Lista todos los productos con estado activo
	@Override
	public List<Producto> consultarProductos() throws Exception {
		List<Producto> listaProductos = productoRepository.findAll();
		
		if (!listaProductos.isEmpty()) {
			return listaProductos;
		}else {
			throw new Exception("No hay productos que mostrar");
		}
	}

	@Override
	public Producto guardarProducto(ProductoDTO productoDTO) throws Exception {
		 
		if(productoDTO == null) {
			throw new Exception("El producto no puede estar vacio.");
		}
		
		if(productoDTO.getNombre().trim().equals("")) {
			throw new Exception("El nombre del producto no puede estar vacio.");
		}
		
		if(productoDTO.getAutor().trim().equals("")) {
			throw new Exception("El dueño del producto no puede estar vacio.");
		}
		
		if(productoDTO.getCategoria().trim().equals("")) {
			throw new Exception("La categoria del producto no puede estar vacio.");
		}
		
		if(productoDTO.getDescripcion().trim().equals("")) {
			throw new Exception("La descripcion del producto no puede estar vacio.");
		}
		
		if(productoDTO.getFechaSubida().trim().equals("")) {
			throw new Exception("La fecha del producto es necesaria.");
		}
		
		if(productoDTO.getTiempo() == null) {
			throw new Exception("Debe ingresar las horas que va a estar abierta la subasta.");
		}
		
		if(productoDTO.getFoto().trim().equals("")) {
			throw new Exception("El producto debe llevar una foto.");
		}
		
		Producto producto = new Producto();
		
		producto.setNombre(productoDTO.getNombre());
		producto.setFechaSubida(productoDTO.getFechaSubida());
		producto.setTiempo(productoDTO.getTiempo());
		producto.setValoracionAutor(productoDTO.getValoracionAutor());
		producto.setCategoria(productoDTO.getCategoria());
		producto.setAutor(productoDTO.getAutor());
		producto.setDescripcion(productoDTO.getDescripcion());
		producto.setFoto(productoDTO.getFoto());
		producto.setArchivo(productoDTO.getArchivo());
		producto.setTipoDeSubasta(productoDTO.getTipoDeSubasta());
		producto.setClienteGanador(productoDTO.getClienteGanador());
		producto.setClienteResponsable(productoDTO.getClienteResponsable());
		producto.setEstado(CONSTANTES.ACTIVO);
		
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> consultarProductosPorValoracionAsc() throws Exception {
		List<Producto> listaProductos = productoRepository.findAll(Sort.by(Sort.Direction.ASC, "valoracionAutor"));
		
		if (!listaProductos.isEmpty()) {
			return listaProductos;
		}else {
			throw new Exception("No hay productos relacionados con los criterios de busqueda");
		}
	}

	@Override
	public List<Producto> consultarProductosPorValoracionDesc() throws Exception {
		List<Producto> listaProductos = productoRepository.findAll(Sort.by(Sort.Direction.DESC, "valoracionAutor"));
		
		if (!listaProductos.isEmpty()) {
			return listaProductos;
		}else {
			throw new Exception("No hay productos relacionados con los criterios de busqueda");
		}
	}

	@Override
	public List<Producto> consultarProductosPorMasReciente() throws Exception {
		List<Producto> listaProductos = productoRepository.findAll(Sort.by(Sort.Direction.ASC, "fechaSubida"));
		
		if (!listaProductos.isEmpty()) {
			return listaProductos;
		}else {
			throw new Exception("No hay productos relacionados con los criterios de busqueda");
		}
	}

	@Override
	public List<Producto> consultarProductoPorNombre(String nombre) throws Exception {
		
		if (nombre.equals("") && nombre.trim().equals("") ) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		List<Producto> productoABuscar = productoRepository.findByNombre(nombre);
		
		if (!productoABuscar.isEmpty()) {
			return productoABuscar;
		}else {
			throw new Exception("No existe ningun producto con ese nombre");
		}
	}

	@Override
	public List<Producto> consultarProductosPorMasAntiguo() throws Exception {
		List<Producto> listaProductos = productoRepository.findAll(Sort.by(Sort.Direction.DESC, "fechaSubida"));
		
		if (!listaProductos.isEmpty()) {
			return listaProductos;
		}else {
			throw new Exception("No hay productos relacionados con los criterios de busqueda");
		}
	}

	@Override
	public List<Producto> consultarProductoPorAutor(String autor) throws Exception {
		
		if (autor.equals("") && autor.trim().equals("") ) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		List<Producto> productoABuscar = productoRepository.findByAutor(autor);
		
		if (!productoABuscar.isEmpty()) {
			return productoABuscar;
		}else {
			throw new Exception(autor + " no tiene ningun producto creado.");
		}
	}

	@Override
	public List<Producto> consultarProductoPorCategoria(String categoria) throws Exception {
		if (categoria.equals("") && categoria.trim().equals("") ) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		List<Producto> productoABuscar = productoRepository.findByCategoria(categoria);
		
		if (!productoABuscar.isEmpty()) {
			return productoABuscar;
		}else {
			throw new Exception("La categoria " + categoria + " no tiene ningun producto creado.");
		}
	}

	@Override
	public List<Producto> consultarProductoPorCliente(Long cedula) throws Exception {
		if (cedula == null) {
			throw new Exception("El cliente con cedula " + cedula + " no existe");
		}
		
		List<Producto> productoABuscar = productoRepository.findByClienteResponsable(cedula);
		
		if (!productoABuscar.isEmpty()) {
			return productoABuscar;
		}else {
			throw new Exception("El cliente con cedula " + cedula + " no tiene productos");
		}
	}

	@Override
	public Producto modificarProducto(ProductoDTO productoDTO) throws Exception {
		 
		if(productoDTO == null) {
			throw new Exception("El producto no puede estar vacio.");
		}
		
		if(productoDTO.getNombre().trim().equals("")) {
			throw new Exception("El nombre del producto no puede estar vacio.");
		}
		
		if(productoDTO.getAutor().trim().equals("")) {
			throw new Exception("El dueño del producto no puede estar vacio.");
		}
		
		if(productoDTO.getCategoria().trim().equals("")) {
			throw new Exception("La categoria del producto no puede estar vacio.");
		}
		
		if(productoDTO.getDescripcion().trim().equals("")) {
			throw new Exception("La descripcion del producto no puede estar vacio.");
		}
		
		if(productoDTO.getFechaSubida().trim().equals("")) {
			throw new Exception("La fecha del producto es necesaria.");
		}
		
		if(productoDTO.getTiempo() == null) {
			throw new Exception("Debe ingresar las horas que va a estar abierta la subasta.");
		}
		
		if(productoDTO.getFoto().trim().equals("")) {
			throw new Exception("El producto debe llevar una foto.");
		}
		
		Producto producto = new Producto();
		
		producto.setIdproducto(productoDTO.getIdproducto());
		producto.setNombre(productoDTO.getNombre());
		producto.setFechaSubida(productoDTO.getFechaSubida());
		producto.setTiempo(productoDTO.getTiempo());
		producto.setValoracionAutor(productoDTO.getValoracionAutor());
		producto.setCategoria(productoDTO.getCategoria());
		producto.setAutor(productoDTO.getAutor());
		producto.setDescripcion(productoDTO.getDescripcion());
		producto.setFoto(productoDTO.getFoto());
		producto.setArchivo(productoDTO.getArchivo());
		producto.setTipoDeSubasta(productoDTO.getTipoDeSubasta());
		producto.setClienteGanador(productoDTO.getClienteGanador());
		producto.setClienteResponsable(productoDTO.getClienteResponsable());
		producto.setEstado(productoDTO.getEstado());
		
		return productoRepository.save(producto);
	}

	@Override
	public Producto consultarProductoPorID(Long id) throws Exception {
		if(id == null){
			throw new Exception("El id no puede estar nulo");
		}
		
		Optional<Producto> producto = productoRepository.findById(id);
		
		if(producto.isPresent()) {
			return producto.get();
		}else {
			throw new Exception("No existe producto con este id");
		}
	}

}
