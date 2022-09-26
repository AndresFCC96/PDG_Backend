package com.betleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betleague.dto.MetodoDePagoDTO;
import com.betleague.service.MetodosDePagoService;

@RestController
@RequestMapping("/api/metodoDePago")
@CrossOrigin("*")
public class MetodoDePagoController {
	
	@Autowired
	private MetodosDePagoService metodosDePago;
	
	@GetMapping("/consultarMetodosDePagosPorCedula")
	public ResponseEntity<?> consultarMetodosDePagosPorCedula(@RequestParam("cedula") Long cedula) throws Exception {
		try {
			return ResponseEntity.ok().body(metodosDePago.obtenerLosMetodosDePagoPorCliente(cedula));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/guardarMetodoDePago")
	public ResponseEntity<?> guardarMetodoDePago(@RequestBody MetodoDePagoDTO metodoDePagoDTO) throws Exception {

		try {
			return ResponseEntity.ok().body(metodosDePago.guardarMetodoDePago(metodoDePagoDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/modificarMetodoDePago")
	public ResponseEntity<?> modificarMetodoDePago(@RequestBody MetodoDePagoDTO metodoDePagoDTO) throws Exception {

		try {
			return ResponseEntity.ok().body(metodosDePago.modificarMetodoDePago(metodoDePagoDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminarMetodoDePago")
	public ResponseEntity<?> eliminarMetodoDePago(@RequestParam("numeroTarjeta") String numeroTarjeta) throws Exception {

		try {
			metodosDePago.eliminarMetodoDePago(numeroTarjeta);
			return ResponseEntity.ok().body(numeroTarjeta);
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
