package com.betleague.service;

import java.util.List;
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
		
		if (categoriaDTO.getNombre().trim().equals("")) {
			throw new Exception("Debe ingresar el nombre de la categoria");
		}
		
		if (categoriaDTO.getNombre() == null) {
			throw new Exception("Debe ingresar el nombre de la categoria");
		}
		
		if (categoriaDTO.getEstado() == null) {
			throw new Exception("Debe ingresar el estado de la categoria");
		}
		
		Categoria categoria = new Categoria();
		categoria.setNombre(categoriaDTO.getNombre());
		categoria.setEstado(categoriaDTO.getEstado());
		return categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> consultarTodasLasCategorias() throws Exception {
		
		List<Categoria> categorias = categoriaRepository.findAll();
		
		if (!categorias.isEmpty()) {
			return categorias;
		}else {
			throw new Exception("No hay categorias para mostrar");
		}
	}

	@Override
	public Categoria modificarCategoria(CategoriaDTO categoriaDTO) throws Exception {
		if (categoriaDTO == null) {
			throw new Exception("La categoria no puede estar vacia");
		}
		
		if (categoriaDTO.getIdcategoria() == null) {
			throw new Exception("el id de la categoria no puede estar vacio");
		}
		
		if (categoriaDTO.getNombre().trim().equals("")) {
			throw new Exception("Debe ingresar el nombre de la categoria");
		}
		
		if (categoriaDTO.getEstado().trim().equals("")) {
			throw new Exception("Debe ingresar el estado de la categoria");
		}
		
		Optional<Categoria> buscarCategoriaPorId = categoriaRepository.findById(categoriaDTO.getIdcategoria());
		
		if (!buscarCategoriaPorId.isPresent()) {
			throw new Exception("No existe una categoria con ese id");
		}
		
		Categoria categoria = new Categoria();
		categoria.setIdcategoria(categoriaDTO.getIdcategoria());
		categoria.setNombre(categoriaDTO.getNombre());
		categoria.setEstado(categoriaDTO.getEstado());
		return categoriaRepository.save(categoria);
	}

}
