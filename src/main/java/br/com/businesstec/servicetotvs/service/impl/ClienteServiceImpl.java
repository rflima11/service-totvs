package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.Cliente;
import br.com.businesstec.model.repository.ClienteRepository;
import br.com.businesstec.servicetotvs.service.ClienteService;
import org.springframework.stereotype.Component;

@Component
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente encontrarClientePeloIdEntidade(Long idEntidade) {
        return clienteRepository.findByIdEntidade(idEntidade).orElseThrow(() -> new RuntimeException("Não encontrado cliente com ID ENTIDADE " + idEntidade));
    }
}
