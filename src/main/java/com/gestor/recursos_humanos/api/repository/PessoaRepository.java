package com.gestor.recursos_humanos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

    Pessoa findByIdPessoa(Integer id);

    Pessoa findByCpf(String cpf);

    Integer countByCpf(String cpf);
    
}
