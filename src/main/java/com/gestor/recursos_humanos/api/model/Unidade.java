package com.gestor.recursos_humanos.api.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Unidade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUnidade;
	private String descricao;
	private String sigla;
	private String email;
	private Boolean unidadePolicial;
	private Boolean unidadeExterna;
	private String cep;
	private String complemento;
	private String numeroLocal;
	private String referencia;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String telefone1;
	private String telefone2;
	private String uf;
	private String latLong;
	private Integer unidadeSuperior;
}
