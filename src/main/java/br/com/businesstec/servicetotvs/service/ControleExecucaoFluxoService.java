package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;

public interface ControleExecucaoFluxoService {

    Long recuperarTipoEntidade(ControleExecucaoFluxo controleExecucaoFluxo);

    void atualizarHora(ControleExecucaoFluxo controleExecucaoFluxo);

    ControleExecucaoFluxo encontrarPeloId(Long idControleExecucaoFluxo);
}
