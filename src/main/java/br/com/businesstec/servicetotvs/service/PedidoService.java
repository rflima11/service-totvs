package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.PedidoEcommerce;

public interface PedidoService {

    PedidoEcommerce encontrarPedidoPeloIdEntidade(Long idEntidade);
}
