package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.models.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{

}
