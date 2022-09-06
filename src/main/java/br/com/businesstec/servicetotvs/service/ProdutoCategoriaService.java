package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.Produto;
import br.com.businesstec.model.entities.ProdutoCategoria;

public interface ProdutoCategoriaService {

    void salvar(ProdutoCategoria produtoCategoria, Produto produto);

    void buscarCategoriasPorProdutos(ControleExecucaoFluxo controleExecucaoFluxo, Produto produto);
}
