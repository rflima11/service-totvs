package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.Marca;

public interface MarcaService {

    Marca salvar(Long idEntidade, String identificadorOrigem, String descricao);

    boolean isMarcaSalva(Long id);
}
