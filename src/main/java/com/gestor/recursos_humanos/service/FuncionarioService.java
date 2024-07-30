package com.gestor.recursos_humanos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.Funcionario;
import com.gestor.recursos_humanos.api.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    public Funcionario buscarFuncionario(Integer id){
        return funcionarioRepository.findByIdFuncionario(id);
    }

    public Boolean cadastrarFuncionario(Funcionario funcionario){
        Boolean registrado = false;
            funcionarioRepository.save(funcionario);
            registrado = true;
        return registrado;
    }

    public Boolean editFuncionario(Funcionario funcionario){
        Boolean editado = false;
        Funcionario func = funcionarioRepository.findByIdFuncionario(funcionario.getIdFuncionario());
        if(func != null){
            funcionarioRepository.save(funcionario);
            editado = true;
        } 
        return editado;
    }

}
