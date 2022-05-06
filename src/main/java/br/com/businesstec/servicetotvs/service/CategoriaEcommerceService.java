package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.CategoriaEcommerce;
import br.com.businesstec.model.entities.ControleExecucaoFluxo;

public interface CategoriaEcommerceService {

    CategoriaEcommerce salvar(CategoriaEcommerce categoriaEcommerce);

    void salvarCategoriasEcommerceByIdProduto(ControleExecucaoFluxo controleExecucaoFluxo, String identificadorOrigem);
}
