package com.gestor.recursos_humanos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.listas.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    
    Estado findByUf(String uf);
}
