package com.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
