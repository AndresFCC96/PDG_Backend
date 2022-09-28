package com.betleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betleague.dto.ClienteDTO;
import com.betleague.dto.ProductoDTO;
import com.betleague.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin("*")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/consultarProductos")
	public ResponseEntity<?> consultarProductos(){
		try {
			return ResponseEntity.ok().body(productoService.consultarProductos());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarProductosMayorPrecio")
	public ResponseEntity<?> consultarProductosPorValoracionMayor(){
		try {
			return ResponseEntity.ok().body(productoService.consultarProductosPorValoracionDesc());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarProductosMenorPrecio")
	public ResponseEntity<?> consultarProductosPorValoracionMenor() throws Exception {

		try {
			return ResponseEntity.ok().body(productoService.consultarProductosPorValoracionAsc());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarProductosMasRecientes")
	public ResponseEntity<?> consultarProductosPorFechaMasRecientes() throws Exception {

		try {
			return ResponseEntity.ok().body(productoService.consultarProductosPorMasReciente());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarProductosMasAntiguos")
	public ResponseEntity<?> consultarProductosPorFechaMasAntiguos() throws Exception {

		try {
			return ResponseEntity.ok().body(productoService.consultarProductosPorMasAntiguo());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarProductoPorNombre")
	public ResponseEntity<?> consultarProductosPorNombre(@RequestParam("nombre") String nombre) throws Exception {
		try {
			return ResponseEntity.ok().body(productoService.consultarProductoPorNombre(nombre));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarProductosPorAutor")
	public ResponseEntity<?> consultarProductosPorAutor(@RequestParam("autor") String autor) throws Exception {

		try {
			return ResponseEntity.ok().body(productoService.consultarProductoPorAutor(autor));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarProductosPorCategoria")
	public ResponseEntity<?> consultarProductosPorCategoria(@RequestParam("categoria") String categoria) throws Exception {

		try {
			return ResponseEntity.ok().body(productoService.consultarProductoPorCategoria(categoria));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/consultarProductosPorCliente")
	public ResponseEntity<?> guardarProducto(@RequestBody ClienteDTO clienteDTO) throws Exception {

		try {
			return ResponseEntity.ok().body(productoService.consultarProductoPorCliente(clienteDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/guardarProducto")
	public ResponseEntity<?> guardarProducto(@RequestBody ProductoDTO productoDTO) throws Exception {

		try {
			return ResponseEntity.ok().body(productoService.guardarProducto(productoDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
