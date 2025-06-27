package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
