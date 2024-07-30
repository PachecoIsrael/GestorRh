package com.gestor.recursos_humanos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer>{
    
}
