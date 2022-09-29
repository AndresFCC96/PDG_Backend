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

import com.betleague.dto.ClienteDTO;
import com.betleague.dto.OfertasDTO;
import com.betleague.dto.ProductoDTO;
import com.betleague.service.OfertasService;

@RestController
@RequestMapping("/api/ofertas")
@CrossOrigin("*")
public class OfertasController {
	
	@Autowired
	OfertasService ofertasService;
	
	@PostMapping("/consultarOfertasPorCliente")
	public ResponseEntity<?> consultarOfertasPorCliente(@RequestBody ClienteDTO cliente) throws Exception {
		try {
			return ResponseEntity.ok().body(ofertasService.encontrarTodasLasOfertasPorCliente(cliente));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarOfertasPorProducto")
	public ResponseEntity<?> consultarOfertasPorProducto(@RequestParam("id") Long id) throws Exception {
		try {
			return ResponseEntity.ok().body(ofertasService.encontrarTodasLasOfertasPorProducto(id));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarOfertaMaximaPorProducto")
	public ResponseEntity<?> consultarOfertaMaximaPorProducto(@RequestParam("id") Long id) throws Exception {
		try {
			return ResponseEntity.ok().body(ofertasService.encontrarLaOfertaMasAlta(id));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/guardarOferta")
	public ResponseEntity<?> guardarOferta(@RequestBody OfertasDTO ofertasDTO) throws Exception {

		try {
			return ResponseEntity.ok().body(ofertasService.guardarOferta(ofertasDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/actualizarOferta")
	public ResponseEntity<?> actualizarOferta(@RequestBody OfertasDTO ofertaDTO) throws Exception {

		try {
			return ResponseEntity.ok().body(ofertasService.modificarOferta(ofertaDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
