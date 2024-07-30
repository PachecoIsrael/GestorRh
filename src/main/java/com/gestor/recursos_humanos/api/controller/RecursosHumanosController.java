package com.gestor.recursos_humanos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestor.recursos_humanos.api.model.Atividade;
import com.gestor.recursos_humanos.api.model.CargoExercicio;
import com.gestor.recursos_humanos.api.model.Classe;
import com.gestor.recursos_humanos.api.model.Contrato;
import com.gestor.recursos_humanos.api.model.Ensino;
import com.gestor.recursos_humanos.api.model.Funcionario;
import com.gestor.recursos_humanos.api.model.Orgao;
import com.gestor.recursos_humanos.api.model.Pessoa;
import com.gestor.recursos_humanos.api.model.Situacao;
import com.gestor.recursos_humanos.api.model.Unidade;
import com.gestor.recursos_humanos.service.AtividadeService;
import com.gestor.recursos_humanos.service.CargoExercicioService;
import com.gestor.recursos_humanos.service.ClasseService;
import com.gestor.recursos_humanos.service.ContratoService;
import com.gestor.recursos_humanos.service.EnsinoService;
import com.gestor.recursos_humanos.service.FuncionarioService;
import com.gestor.recursos_humanos.service.OrgaoService;
import com.gestor.recursos_humanos.service.PessoaService;
import com.gestor.recursos_humanos.service.SituacaoService;
import com.gestor.recursos_humanos.service.UnidadeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("rh/")
public class RecursosHumanosController {
    
    @Autowired
    private UnidadeService unidadeService;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private ContratoService contratoService;
    @Autowired
    private OrgaoService orgaoService;
    @Autowired
    private EnsinoService ensinoService;
    @Autowired
    private SituacaoService situacaoService;
    @Autowired
    private ClasseService classeService;
    @Autowired
    private AtividadeService atividadeService;
    @Autowired
    private CargoExercicioService cargoExercicioService;
    
    @GetMapping("buscar/unidade")
    public Unidade buscarUnidade(@RequestParam Integer id){
        return unidadeService.findByIdUnidade(id);
    }

    @PostMapping("cadastrar/unidade")
    public Boolean cadastroUnidade(@RequestBody Unidade unidade){
        return unidadeService.cadastraUnidade(unidade);
    }

    @PostMapping("editar/unidade")
    public Boolean editUnidade(@RequestBody Unidade unidade){
        return unidadeService.editUnidade(unidade);
    }

    @PostMapping("cadastrar/pessoa")
    public Boolean cadastroPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @GetMapping("buscar/pessoa")
    public Pessoa buscarPessoa(@RequestParam Integer id){
        return pessoaService.buscarPessoa(id);
    }

    @PostMapping("editar/pessoa")
    public Boolean editPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.editPessoa(pessoa);
    }

    @PostMapping("cadastrar/funcionario")
    public Boolean cadastraFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.cadastrarFuncionario(funcionario);
    }

    @GetMapping("buscar/funcionario")
    public Funcionario buscarFuncionario(@RequestParam Integer id){
        return funcionarioService.buscarFuncionario(id);
    }

    @PostMapping("editar/funcionario")
    public Boolean editFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.editFuncionario(funcionario);
    }

    @GetMapping("buscar/contrato")
    public List<Contrato> buscarContrato(){
        return contratoService.buscarContrato();
    }
    
    @GetMapping("buscar/orgao")
    public List<Orgao> buscarOrgao(){
        return orgaoService.buscarOrgao();
    }

    @GetMapping("buscar/ensino")
    public List<Ensino> buscarEnsino(){
        return ensinoService.buscarEnsino();
    }
    
    @GetMapping("buscar/situacao")
    public List<Situacao> buscarSituacao(){
        return situacaoService.buscarSituacao();
    }
    @PostMapping("editar/situacao")
    public Boolean editarSituacao(@RequestBody Situacao situacao){
        return situacaoService.editarSituacao(situacao);
    }
    @PostMapping("cadastrar/situacao")
    public Boolean cadastrarSituacao(@RequestBody Situacao situacao){
        return situacaoService.cadastrarSituacao(situacao);
    }
    
    @GetMapping("buscar/classe")
    public List<Classe> buscarClasse(){
        return classeService.buscarClasse();
    }
    
    @GetMapping("buscar/atividade")
    public List<Atividade> buscarAtividade(){
        return atividadeService.buscarAtividade();
    }
    
    @GetMapping("buscar/cargo/exercicio")
    public List<CargoExercicio> buscarCargoExercicio(){
        return cargoExercicioService.buscarCargoExercicio();
    }

    
    
}
