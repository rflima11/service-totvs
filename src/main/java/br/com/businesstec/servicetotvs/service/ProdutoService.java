package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.Produto;

import java.util.List;

public interface ProdutoService {

    Produto salvar(Produto produto);

    Produto findByIdentificadorOrigem(String identificadorOrigem);

    List<String> encontrarTodosIdentificadoresOrigem();
}
