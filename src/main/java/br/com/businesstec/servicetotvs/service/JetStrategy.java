package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;

public interface JetStrategy {

    void executar(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade);

    EnumNomeStrategy getNomeStrategy();
}
