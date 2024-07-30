package com.gestor.recursos_humanos.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.Ensino;

@Repository
public interface EnsinoRepository extends JpaRepository<Ensino, Integer> {
    
}
