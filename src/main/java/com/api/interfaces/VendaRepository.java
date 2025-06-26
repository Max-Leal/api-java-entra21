package com.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Pedido;

public interface VendaRepository extends JpaRepository<Pedido, Long>{

}
