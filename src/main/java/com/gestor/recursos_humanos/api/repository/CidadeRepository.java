package com.gestor.recursos_humanos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestor.recursos_humanos.api.model.listas.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
    Cidade findByCodigoIbge(Integer codigoIbge);
}
