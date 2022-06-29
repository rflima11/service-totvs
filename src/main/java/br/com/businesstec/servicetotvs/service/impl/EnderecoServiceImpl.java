package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.Cliente;
import br.com.businesstec.model.entities.Endereco;
import br.com.businesstec.model.repository.EnderecoRepository;
import br.com.businesstec.servicetotvs.service.EnderecoService;
import org.springframework.stereotype.Component;

@Component
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoServiceImpl(EnderecoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Endereco encontrarPeloIdCliente(Long idCliente) {
        return repository.findByIdCliente(idCliente).orElseThrow(() -> new RuntimeException("Não encontrado cliente com o ID: " + idCliente));
    }
}
