package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.Categoria;
import br.com.businesstec.model.entities.ControleExecucaoFluxo;

public interface CategoriaService {

    Categoria salvar(Categoria categoria);

    void salvarCategoriasByIdProduto(ControleExecucaoFluxo controleExecucaoFluxo, String identificadorOrigem);
}
