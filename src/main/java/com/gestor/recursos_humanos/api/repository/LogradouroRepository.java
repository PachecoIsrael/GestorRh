package com.gestor.recursos_humanos.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.pessoa.Logradouro;

@Repository
public interface LogradouroRepository extends JpaRepository<Logradouro, Integer>{
    
    Optional<Logradouro> findByCepAndCepDesconhecidoFalse(String cep);
}
