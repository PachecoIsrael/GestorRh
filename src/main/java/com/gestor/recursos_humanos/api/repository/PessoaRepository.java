package com.gestor.recursos_humanos.api.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.recursos_humanos.api.model.pessoa.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

    Pessoa findByIdPessoa(Integer id);

    Optional<Pessoa> findByCpf(String cpf);

    Integer countByCpf(String cpf);

    List<Pessoa> findByNomeAndNomeMaeAndDataNascimento(String nome, String nomeMae, LocalDate dataNascimento);
    
}
