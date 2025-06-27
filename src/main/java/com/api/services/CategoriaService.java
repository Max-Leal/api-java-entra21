package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.Categoria;
import com.api.repositories.CategoriaRepository;

@Service
public class CategoriaService {


	@Autowired
	private CategoriaRepository repository;
	
	public Categoria salvar(Categoria c) {
		//TODO: depois aplicar validações
		return repository.save(c);
	}
	
	public List<Categoria> getAll() {
		return repository.findAll();
	}
	
	public Categoria getCategoriaById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
	}
	
	public Categoria alterar(Long id, Categoria c) {
		Categoria catSalva = getCategoriaById(id);
		catSalva.setDescricao(c.getDescricao());
		
		return repository.save(catSalva);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
}
