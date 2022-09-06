package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.StatusPedidoEcommerce;
import br.com.businesstec.model.repository.StatusPedidoEcommerceRepository;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import br.com.businesstec.servicetotvs.service.StatusPedidoService;
import org.springframework.stereotype.Service;

@Service
public class StatusPedidoServiceImpl implements StatusPedidoService {

    private final StatusPedidoEcommerceRepository repository;
    private final EntidadeService entidadeService;

    public StatusPedidoServiceImpl(StatusPedidoEcommerceRepository repository, EntidadeService entidadeService) {
        this.repository = repository;
        this.entidadeService = entidadeService;
    }

    @Override
    public StatusPedidoEcommerce salvar(StatusPedidoEcommerce entity) {
        entity.setIdEntidade(entidadeService.salvar(EnumTipoEntidade.STATUS_PEDIDO).getId());
        return repository.save(entity);
    }
}
