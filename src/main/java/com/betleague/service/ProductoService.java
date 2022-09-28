package com.betleague.service;

import java.util.List;

import com.betleague.domain.Producto;
import com.betleague.dto.ClienteDTO;
import com.betleague.dto.ProductoDTO;

public interface ProductoService {

	List<Producto> consultarProductos() throws Exception;
	
	List<Producto> consultarProductosPorValoracionAsc() throws Exception;

	List<Producto> consultarProductosPorValoracionDesc() throws Exception;
	
	List<Producto> consultarProductosPorMasAntiguo() throws Exception;
	
	List<Producto> consultarProductosPorMasReciente() throws Exception;
	
	List<Producto> consultarProductoPorNombre(String nombre) throws Exception;
	
	List<Producto> consultarProductoPorAutor(String autor) throws Exception;
	
	List<Producto> consultarProductoPorCliente(ClienteDTO clienteDTO) throws Exception;
	
	List<Producto> consultarProductoPorCategoria(String categoria) throws Exception;
	
	Producto guardarProducto(ProductoDTO productoDTO) throws Exception;
}
