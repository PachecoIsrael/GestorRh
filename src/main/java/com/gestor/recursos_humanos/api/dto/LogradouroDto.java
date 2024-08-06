package com.gestor.recursos_humanos.api.dto;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class LogradouroDto{
    private String cep;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    @Transient
    Boolean erro = false;  
}
