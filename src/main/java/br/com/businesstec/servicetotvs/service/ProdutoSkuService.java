package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;

public interface ProdutoSkuService {

    void salvarProdutosSkuByIdProduto(ControleExecucaoFluxo controleExecucaoFluxo, String idProduto);
}
