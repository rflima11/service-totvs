package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.VariacaoProdutoSku;

public interface VariacaoProdutoSkuService {

    void salvarVariacaoProdutoSku(ControleExecucaoFluxo controleExecucaoFluxo, Long idProdutoSku);
}
