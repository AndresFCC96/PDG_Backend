package com.betleague.service;

import com.betleague.domain.Categoria;
import com.betleague.dto.CategoriaDTO;

public interface CategoriaService {
	
	Categoria consultarCategoriaPorId(Long idCategoria) throws Exception;
	
	Categoria consultarCategoriaPorNombre(String categoria) throws Exception;
	
	Categoria guardarCategoria(CategoriaDTO categoriaDTO) throws Exception;
}
