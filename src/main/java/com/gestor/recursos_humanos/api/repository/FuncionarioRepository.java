package com.gestor.recursos_humanos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

    Funcionario findByIdFuncionario(Integer idFuncionario);

    Integer countByIdFuncionario(Integer funcionario);
    
}
