package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;

public interface ProdutoSkuService {

    void salvarProdutosSkuByIdProduto(ControleExecucaoFluxo controleExecucaoFluxo, String idProduto);
}
