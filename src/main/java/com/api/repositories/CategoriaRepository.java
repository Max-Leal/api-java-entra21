package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
