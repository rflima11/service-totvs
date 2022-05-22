package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.ProdutoSku;

public interface ProdutoSkuService {

    void salvarProdutosSkuByIdProduto(ControleExecucaoFluxo controleExecucaoFluxo, String idProduto);

    ProdutoSku salvar(ProdutoSku produtoSku);
}
