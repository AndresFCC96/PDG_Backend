package com.betleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betleague.dto.CategoriaDTO;
import com.betleague.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/consultarCategorias")
	public ResponseEntity<?> consultarCategorias() throws Exception {
		try {
			return ResponseEntity.ok().body(categoriaService.consultarTodasLasCategorias());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarCategoriaPorId")
	public ResponseEntity<?> consultarCategoriasPorId(@RequestParam("id") Long id) throws Exception {
		try {
			return ResponseEntity.ok().body(categoriaService.consultarCategoriaPorId(id));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarCategoriaPorNombre")
	public ResponseEntity<?> consultarCategoriaPorNombre(@RequestParam("nombre") String nombre) throws Exception {
		try {
			return ResponseEntity.ok().body(categoriaService.consultarCategoriaPorNombre(nombre));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/guardarCategoria")
	public ResponseEntity<?> guardarCategoria(@RequestBody CategoriaDTO categoriaDTO) throws Exception {

		try {
			return ResponseEntity.ok().body(categoriaService.guardarCategoria(categoriaDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/modificarCategoria")
	public ResponseEntity<?> modificarCategoria(@RequestBody CategoriaDTO categoriaDTO) throws Exception {

		try {
			return ResponseEntity.ok().body(categoriaService.modificarCategoria(categoriaDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
