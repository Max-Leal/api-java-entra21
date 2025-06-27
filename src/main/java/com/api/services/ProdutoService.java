package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.Produto;
import com.api.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public Produto salvar(Produto produto) {
		//TODO: depois aplicar validações
		return repository.save(produto);
	}
	
	public List<Produto> getAll() {
		return repository.findAll();
	}
	
	
	
}
