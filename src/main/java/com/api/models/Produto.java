package com.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descricao;
	private Double preco;
	private String unidadeMedida;
	private int estoque;
	private String fornecedor;
	@ManyToOne
	private Categoria categoria; //agregação
	
	public Produto() {}

	public Produto(String descricao, Double preco, String unidadeMedida, int estoque, String fornecedor) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		this.unidadeMedida = unidadeMedida;
		this.estoque = estoque;
		this.fornecedor = fornecedor;
	}

	public Produto(Long id, String descricao, Double preco, String unidadeMedida, int estoque, String fornecedor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.unidadeMedida = unidadeMedida;
		this.estoque = estoque;
		this.fornecedor = fornecedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
}
