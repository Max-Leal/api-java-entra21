package com.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
