package com.gestor.recursos_humanos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer>{

    Atividade findByIdAtividade(Integer id);
    
}
