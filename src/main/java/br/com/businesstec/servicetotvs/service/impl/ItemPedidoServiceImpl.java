package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ItemPedidoEcommerce;
import br.com.businesstec.model.repository.ItemPedidoEcommerceRepository;
import br.com.businesstec.servicetotvs.service.ItemPedidoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

    private final ItemPedidoEcommerceRepository repository;


    public ItemPedidoServiceImpl(ItemPedidoEcommerceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemPedidoEcommerce> recuperarItensPedido(Long idPedido) {
        return repository.findByIdPedidoEcommerce(idPedido);
    }
}
