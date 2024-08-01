package com.gestor.recursos_humanos.api.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gestor.recursos_humanos.api.model.pessoa.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Funcionario implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuncionario;

    private String matricula;
    private String matriculaNova;
    private String especialidade;
    
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_cargo")
    private CargoExercicio cargoExercicio;
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_contrato")
    private Contrato contrato;
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_orgao")
    private Orgao orgao;
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_atividade")
    private Atividade atividade;
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_situacao")
    private Situacao situacao;
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_pessoa")
    private Pessoa pessoa;
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_unidade")
    private Unidade unidade;
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_classe")
    private Classe classe;

    private Boolean ativo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entrada;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private Date exercicio;

}
