package com.betleague.service;

import java.util.List;

import com.betleague.domain.Categoria;
import com.betleague.dto.CategoriaDTO;

public interface CategoriaService {
	
	List<Categoria> consultarTodasLasCategorias() throws Exception; 
	
	Categoria consultarCategoriaPorId(Long idCategoria) throws Exception;
	
	Categoria consultarCategoriaPorNombre(String categoria) throws Exception;
	
	Categoria guardarCategoria(CategoriaDTO categoriaDTO) throws Exception;
	
	Categoria modificarCategoria(CategoriaDTO categoriaDTO) throws Exception;
}
