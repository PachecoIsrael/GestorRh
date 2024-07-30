package com.gestor.recursos_humanos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.Pessoa;
import com.gestor.recursos_humanos.api.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscarPessoa(Integer idPessoa){
        return pessoaRepository.findByIdPessoa(idPessoa);
    }
    
    public Boolean cadastrarPessoa(Pessoa pessoa){
        Integer registro = pessoaRepository.countByCpf(pessoa.getCpf());
        Boolean registrado = false;
        if(registro == 0){
            pessoaRepository.save(pessoa);
            registrado = true;
        } else {
            registrado = false;
        }
        return registrado;
    }

    public Boolean editPessoa(Pessoa pessoa){
        Boolean editado = false;
        Pessoa editarPessoa = pessoaRepository.findByIdPessoa(pessoa.getIdPessoa());
        if(editarPessoa != null){
            pessoaRepository.save(pessoa);
            editado = true;
        } else {
            editado = false;
        }
        return editado;
    }
}
