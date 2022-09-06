package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.PedidoEcommerce;
import br.com.businesstec.model.repository.PedidoEcommerceRepository;
import br.com.businesstec.servicetotvs.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoEcommerceRepository repository;

    public PedidoServiceImpl(PedidoEcommerceRepository repository) {
        this.repository = repository;
    }

    @Override
    public PedidoEcommerce encontrarPedidoPeloIdEntidade(Long idEntidade) {
        return repository.findByIdEntidade(idEntidade).orElseThrow(() -> new RuntimeException("Não encontrado pedido com ID ENTIDADE " + idEntidade));
    }
}
