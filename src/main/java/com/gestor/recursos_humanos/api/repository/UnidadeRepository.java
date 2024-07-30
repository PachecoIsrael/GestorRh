package com.gestor.recursos_humanos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

    Unidade findByIdUnidade(Integer idUnidade);

    Integer countByIdUnidade(Integer idUnidade);
    
    Integer countBySigla(String sigla);

}
