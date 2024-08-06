package com.gestor.recursos_humanos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.pessoa.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer>{

    Bairro findByCidadeIdCidadeAndDescricao(Integer idCidade, String descricao);
    
}
