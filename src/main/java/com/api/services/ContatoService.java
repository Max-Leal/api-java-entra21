package com.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.models.Contato;
import com.api.repositories.ContatoRepository;

@Service
public class ContatoService {
	private ContatoRepository repository;
	
	public ContatoService(ContatoRepository repository) {
		this.repository = repository;
	}

	public Contato salvar(Contato contato) {
		if (contato.getNome().isEmpty()) {
			throw new RuntimeException("Nome inválido");
		}
		if (contato.getEmail().isEmpty()) {
			throw new RuntimeException("Email inválido");
		} 

		if (!contato.getEmail().contains("@")) {
			throw new RuntimeException("Email inválido");
		} 
		return repository.save(contato);
	}
	
	public List<Contato> getAll() {
		return repository.findAll();
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
	public Contato getContatoById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
	}
	
	public Contato alterar(Contato contato) {
		Contato contatoSalvo = getContatoById(contato.getId());
		
		if (contato.getNome().isEmpty()) {
			throw new RuntimeException("Nome inválido");
		}

		if (contato.getEmail().isEmpty()) {
			throw new RuntimeException("O email deve ser informado");
		}

		if (!contato.getEmail().contains("@")) {
			throw new RuntimeException("Email inválido");
		}
		
		contatoSalvo.setNome(contato.getNome());
		contatoSalvo.setEmail(contato.getEmail());
		
		return repository.save(contatoSalvo);
	}
}
