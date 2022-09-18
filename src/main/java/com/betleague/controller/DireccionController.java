package com.betleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betleague.dto.DireccionDTO;
import com.betleague.dto.ProductoDTO;
import com.betleague.service.DireccionService;

@RestController
@RequestMapping("/api/direccion")
@CrossOrigin("*")
public class DireccionController {
	
	@Autowired
	private DireccionService direccionService;
	
	@GetMapping("/consultarDireccionesPorCedula")
	public ResponseEntity<?> consultarDireccionesPorCedulaCliente(@RequestParam("cedula") Long cedula){
		try {
			return ResponseEntity.ok().body(direccionService.listarDireccionesPorCliente(cedula));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/guardarDireccion")
	public ResponseEntity<?> guardarDireccion(@RequestBody DireccionDTO direccionDTO) throws Exception {

		try {
			return ResponseEntity.ok().body(direccionService.crearDireccion(direccionDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
