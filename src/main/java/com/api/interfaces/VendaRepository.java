package com.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

}
