package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.model.entidades.Marca;

public interface MarcaService {

    Marca salvar(Long idEntidade, String identificadorOrigem, String descricao);

    boolean isMarcaSalva(Long id);
}
