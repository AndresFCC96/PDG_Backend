package com.betleague.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betleague.domain.Categoria;
import com.betleague.dto.CategoriaDTO;
import com.betleague.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria consultarCategoriaPorId(Long idCategoria) throws Exception {
		
		if (idCategoria == null) {
			throw new Exception("El id de la categoria no puede estar nulo");
		}
		
		Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
		
		if (categoria.isPresent()) {
			return categoria.get();
		}else {
			throw new Exception("No existe categoria con el id " + idCategoria);
		}
	}

	@Override
	public Categoria consultarCategoriaPorNombre(String categoria) throws Exception {
		
		if (categoria == null) {
			throw new Exception("La categoria no puede estar nula");
		}
		
		Optional<Categoria> categoriaPorNombre = categoriaRepository.findByNombre(categoria);
		
		if (categoriaPorNombre.isPresent()) {
			return categoriaPorNombre.get();
		}else {
			throw new Exception("No existe categoria con el nombre de " + categoria);
		}
	}

	@Override
	public Categoria guardarCategoria(CategoriaDTO categoriaDTO) throws Exception {

		if (categoriaDTO == null) {
			throw new Exception("La categoria no puede estar vacia");
		}
		
		if (categoriaDTO.getIdCategoria() == null) {
			throw new Exception("El id de la categoria no puede estar vacia");
		}
		
		if (categoriaDTO.getNombre() == null) {
			throw new Exception("Debe ingresar el nombre de la categoria");
		}
		
		Optional<Categoria> buscarCategoria = categoriaRepository.findById(categoriaDTO.getIdCategoria());
		
		if (buscarCategoria.isPresent()) {
			throw new Exception("La cagoria con id " + categoriaDTO.getIdCategoria() + " ya existe");
		}
		
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(categoriaDTO.getIdCategoria());
		categoria.setNombre(categoriaDTO.getNombre());
		return categoriaRepository.save(categoria);
	}

}
