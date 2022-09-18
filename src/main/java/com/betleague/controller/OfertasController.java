package com.betleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betleague.dto.ClienteDTO;
import com.betleague.dto.ProductoDTO;
import com.betleague.service.OfertasService;

@RestController
@RequestMapping("/api/ofertas")
@CrossOrigin("*")
public class OfertasController {
	
	@Autowired
	OfertasService ofertasService;
	
	@GetMapping("/consultarOfertasPorCliente")
	public ResponseEntity<?> consultarOfertasPorCliente(@RequestBody ClienteDTO cliente) throws Exception {
		try {
			return ResponseEntity.ok().body(ofertasService.encontrarTodasLasOfertasPorCliente(cliente));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarOfertasPorProducto")
	public ResponseEntity<?> consultarOfertasPorProducto(@RequestBody ProductoDTO producto) throws Exception {
		try {
			return ResponseEntity.ok().body(ofertasService.encontrarTodasLasOfertasPorProducto(producto));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
