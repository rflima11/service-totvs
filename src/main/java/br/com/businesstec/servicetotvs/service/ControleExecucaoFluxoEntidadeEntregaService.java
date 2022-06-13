package br.com.businesstec.servicetotvs.service;


import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;
import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidadeEntrega;

public interface ControleExecucaoFluxoEntidadeEntregaService {

    ControleExecucaoFluxoEntidadeEntrega registrarExecucao(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade);

    ControleExecucaoFluxoEntidadeEntrega registrarErro(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade, String descricaoErro);
}
