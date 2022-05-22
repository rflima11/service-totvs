package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.ProdutoCategoria;

public interface ProdutoCategoriaService {

    ProdutoCategoria salvar(ProdutoCategoria produtoCategoria);

    void buscarCategoriasPorProdutos(ControleExecucaoFluxo controleExecucaoFluxo, String externalIdProduto);
}
