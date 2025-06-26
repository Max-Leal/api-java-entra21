package com.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
