package com.gestor.recursos_humanos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.Situacao;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, Integer>{
    
    Situacao findByIdSituacao(Integer id);
    
}
