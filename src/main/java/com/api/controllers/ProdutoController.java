package com.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Contato;
import com.api.models.Produto;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

	private static List<Produto> produtos = new ArrayList<>();
	
	public ProdutoController() {
		produtos.add(new Produto(1L,"tomate",4.43,"kg",15,"Ropemate"));
		produtos.add(new Produto(2L,"Arface",2.60,"kg",7,"Ropeface"));
	}
	
	@GetMapping
	public List<Produto> getAll() {
		return produtos;
	}
	
	@PostMapping
	public Produto insert(@RequestBody Produto produto) {
		produto.setId(produtos.size()+1L);
		produtos.add(produto);
		return produto;
	}
	
	@GetMapping("/{id}")
	public Produto getOne(@PathVariable Long id) {
		for (Produto p : produtos) {
			if (p.getId() == id) {
				return p;
			}
			
		}
	return null;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		for (Produto p : produtos) {
			if (p.getId() == id) {
				produtos.remove(p);
			}
			
		}
	}
	
}
