package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;

public interface ControleExecucaoFluxoEntidadeService {

    void registrar(Long idControleExecucaoFluxo, Long idEntidade);

    ControleExecucaoFluxoEntidade atualizarIntegracao(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade);

    ControleExecucaoFluxoEntidade atualizarIntegracaoErro(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade);
}
