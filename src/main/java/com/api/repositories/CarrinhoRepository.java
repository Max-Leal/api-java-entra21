package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}
