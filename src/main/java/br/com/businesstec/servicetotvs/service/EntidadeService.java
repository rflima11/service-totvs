package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.model.entidades.Entidade;

public interface EntidadeService {

    Entidade salvar(EnumTipoEntidade tipoEntidade);
}
