package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.models.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
