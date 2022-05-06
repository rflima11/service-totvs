package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.Entidade;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;

public interface EntidadeService {

    Entidade salvar(EnumTipoEntidade tipoEntidade);
}
