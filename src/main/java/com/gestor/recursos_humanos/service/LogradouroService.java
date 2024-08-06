package com.gestor.recursos_humanos.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.gestor.recursos_humanos.api.dto.LogradouroDto;
import com.gestor.recursos_humanos.api.dto.PessoaDto;
import com.gestor.recursos_humanos.api.model.pessoa.Logradouro;
import com.gestor.recursos_humanos.api.model.pessoa.Pessoa;
import com.gestor.recursos_humanos.api.repository.CidadeRepository;
import com.gestor.recursos_humanos.api.repository.EstadoRepository;
import com.gestor.recursos_humanos.api.repository.LogradouroRepository;

@Service
public class LogradouroService {
    
    @Autowired
	private ModelMapper modelMapper;

    @Autowired
    private RestTemplate http;

    @Autowired
    private LogradouroRepository logradouroRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private BairroService bairroService;

    private final String viaCepUrl = "https://viacep.com.br/ws/";

    public Logradouro mapearDados(PessoaDto pessoaDto, Pessoa pessoaSave){
        Logradouro logradouro = modelMapper.map(pessoaDto, Logradouro.class);

        var logradouroSave = getByCep(logradouro.getCep());

        if (logradouroSave.getCep() != null ) {
            enderecoService.salvarEndereco(pessoaDto, logradouro, pessoaSave);
        }else {
            var logradouroWithoutCepNotFound = this.save(logradouro);
            enderecoService.salvarEndereco(pessoaDto, logradouroWithoutCepNotFound, pessoaSave);
        }
        return logradouroRepository.save(logradouro);
    }

    @Transactional
    public Logradouro salvar(Logradouro logradouro){
        Logradouro novo = new Logradouro();
        novo.setCep(logradouro.getCep());
        novo.setComplemento(logradouro.getComplemento());
        novo.setIbge(logradouro.getIbge());
        novo.setLogradouro(logradouro.getLogradouro());
        return logradouroRepository.save(novo);
    }

    @Transactional
    public Logradouro getByCep(String cep) {
        return logradouroRepository.findByCepAndCepDesconhecidoFalse(cep).orElseGet(() -> {
                Logradouro logradouroViaCep = getLogradouroByCep(cep);
                return !logradouroViaCep.getErro() && logradouroViaCep.getCep() != null ? logradouroRepository.save(logradouroViaCep) : logradouroViaCep;
            });
    }

    private Logradouro getLogradouroByCep(String cep) {
        try {
            LogradouroDto logradouroDto = http.getForObject(this.getUriCEPAPI(cep), LogradouroDto.class);
            Logradouro logradouro = new Logradouro();
                    if (!logradouroDto.getErro()) {
                        logradouro.setCep(logradouroDto.getCep());
                        logradouro.setComplemento(logradouroDto.getComplemento());
                        logradouro.setIbge(logradouroDto.getIbge());
                        logradouro.setLogradouro(logradouroDto.getLogradouro());
                        logradouro.setEstado(estadoRepository.findByUf(logradouroDto.getUf()));
                        logradouro.setCidade(cidadeRepository.findByCodigoIbge(Integer.parseInt(logradouroDto.getIbge())));
                        
                        var bairro = bairroService.findByBairroPorIdCidadeNome(logradouro.getCidade().getIdCidade(), logradouroDto.getBairro());
                        var withoutBairro = bairroService.findByBairroPorIdCidadeNome(logradouro.getCidade().getIdCidade(), "Centro");
                        logradouro.setBairro(bairro != null ? bairro : withoutBairro);
                    }
                    return logradouro;
        } catch (Exception e) {
            throw new IllegalStateException("Houve um erro ao tentar recuperar o endereço pelo cep");
        }
    }

    private String getUriCEPAPI(String cep) {
        return String.format("%s%s/json/", viaCepUrl, cepTratamento(cep));
    }
    
    private String cepTratamento(String cep) {
        return cep.replaceAll("[.-]", "");
    }

    @Transactional
	public Logradouro save(Logradouro logradouro) {
    	logradouro.setCepDesconhecido(true);
		return logradouroRepository.save(logradouro);
	}
}
