package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.Venda;
import com.api.repositories.VendaRepository;

@Service
public class VendaService {


	@Autowired
	private VendaRepository repository;
	
	public Venda salvar(Venda v) {
		//TODO: depois aplicar validações
		return repository.save(v);
	}
	
	public List<Venda> getAll() {
		return repository.findAll();
	}
	
	public Venda getCategoriaById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
	}
	
	public Venda alterar(Long id, Venda v) {
		Venda vendaSalva = getCategoriaById(id);
		
		vendaSalva.setData(v.getData());

		
		return repository.save(vendaSalva);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
