package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.Pedido;
import com.api.repositories.PedidoRepository;

@Service
public class PedidoService {


	@Autowired
	private PedidoRepository repository;
	
	public Pedido salvar(Pedido p) {
		//TODO: depois aplicar validações
		return repository.save(p);
	}
	
	public List<Pedido> getAll() {
		return repository.findAll();
	}
	
	public Pedido getCategoriaById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
	}
	
	public Pedido alterar(Long id, Pedido p) {
		Pedido pediSalvo = getCategoriaById(id);
		
		pediSalvo.setData(p.getData());
		
		return repository.save(pediSalvo);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
}
