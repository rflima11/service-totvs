package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ItemPedidoEcommerce;

import java.util.List;

public interface ItemPedidoService {

    List<ItemPedidoEcommerce> recuperarItensPedido(Long idPedido);
}
