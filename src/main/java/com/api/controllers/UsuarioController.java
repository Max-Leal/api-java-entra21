package com.api.controllers;

import java.util.List;

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

import com.api.models.Contato;
import com.api.services.ContatoService;

@RestController
@RequestMapping("/api/v1/usuarios") // http://localhost:8080/api/v1/usuarios
public class UsuarioController {
	private ContatoService service;

	public UsuarioController(ContatoService service) {
		this.service = service;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody Contato cont) {
		try {			
			return ResponseEntity
			.status(HttpStatus.OK)
			.body(service.alterar(cont));
		}catch (Exception e) {
			return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(e.getMessage());
		}
	}

	@GetMapping
	public List<Contato> getAll() {
		return service.getAll();
	}

	@PostMapping
	public ResponseEntity<?> post(@RequestBody Contato contato) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(contato));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			return ResponseEntity.ok().body(service.getContatoById(id));
		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deletar(id);
	}
}
