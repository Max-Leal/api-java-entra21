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
	
	public Produto getProdutoById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
	}
	
	public Produto alterar(Long id, Produto p) {
		Produto produtoSalvo = getProdutoById(id);
		
		
		produtoSalvo.setDescricao(p.getDescricao());
		produtoSalvo.setPreco(p.getPreco());
		produtoSalvo.setEstoque(p.getEstoque());
		produtoSalvo.setFornecedor(p.getFornecedor());
		produtoSalvo.setUnidadeMedida(p.getUnidadeMedida());
		produtoSalvo.setCategoria(p.getCategoria());
		
		return repository.save(produtoSalvo);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
}
