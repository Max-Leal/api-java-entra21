package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Pedido;
import com.api.services.PedidoService;

@RestController
@RequestMapping("api/v1/pedidos")
public class PedidoController {

	
	@Autowired
	private PedidoService service;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Pedido p) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(p));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody Pedido p) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.alterar(id,p));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProdutoById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok().body(service.getCategoriaById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deletar(id);
	}

}
