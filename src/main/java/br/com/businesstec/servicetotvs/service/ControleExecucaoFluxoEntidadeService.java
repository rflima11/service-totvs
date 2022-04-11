package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxoEntidade;

public interface ControleExecucaoFluxoEntidadeService {

    ControleExecucaoFluxoEntidade registrar(Long idControleExecucaoFluxo, Long idEntidade);
}
