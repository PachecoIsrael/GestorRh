package com.gestor.recursos_humanos.service;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestor.recursos_humanos.api.dto.PessoaDto;
import com.gestor.recursos_humanos.api.model.exceptions.PessoaAlreadyRegisteredException;
import com.gestor.recursos_humanos.api.model.pessoa.Pessoa;
import com.gestor.recursos_humanos.api.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
	private ModelMapper modelMapper;

    public Pessoa buscarPessoa(Integer idPessoa){
        return pessoaRepository.findByIdPessoa(idPessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @Transactional
	public Pessoa criarNovaPessoa(PessoaDto pessoaDto) {
        Pessoa pessoa = modelMapper.map(pessoaDto, Pessoa.class);
    	var pessoaSave = this.salvarPessoa(pessoa);
        return pessoaSave;
    }

    @Transactional
	public Pessoa salvarPessoa(Pessoa pessoa) {
    	Pessoa existPessoa = existsPessoa(pessoa, pessoa.getCpf());
    	if (existPessoa != null) {
    		return pessoaRepository.save(existPessoa);
		}
		return existPessoa;
    }
    
    public Pessoa existsPessoa(Pessoa pessoa, String cpf) {
    	Optional<Pessoa> pessoaOpt = null;
    	pessoaOpt = pessoaRepository.findByCpf(cpf);
    	
    	Pessoa pessoa2 = trataPessoa(pessoa);

    	if (!verificaPessoaTriChave(pessoa2).isEmpty() || pessoaOpt.isPresent() ) {
    		throw new PessoaAlreadyRegisteredException("Pessoa já consta na base de dados");
		} 
    	
    	return pessoa2;
    }

    private List<Pessoa> verificaPessoaTriChave(Pessoa pessoa) {
    	return pessoaRepository.findByNomeAndNomeMaeAndDataNascimento(pessoa.getNome(), pessoa.getNomeMae(), pessoa.getDataNascimento());
    }

	public Pessoa trataPessoa(Pessoa pessoa) {
		if (pessoa.getNome() != null && !pessoa.getNome().isEmpty()) {
			pessoa.setNome(removerAcentos(pessoa.getNome()).toUpperCase().trim());
		}
		if (pessoa.getNomeMae() != null && !pessoa.getNomeMae().isEmpty()) {
			pessoa.setNomeMae(removerAcentos(pessoa.getNomeMae()).toUpperCase().trim());
		}
		if (pessoa.getNomePai() != null && !pessoa.getNomePai().isEmpty()) {
			pessoa.setNomePai(removerAcentos(pessoa.getNomePai()).toUpperCase().trim());
		}
		if (pessoa.getNomeSocial() != null && !pessoa.getNomeSocial().isEmpty()) {
			pessoa.setNomeSocial(removerAcentos(pessoa.getNomeSocial()).toUpperCase().trim());
		}

		return pessoa;
	}
    public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}
