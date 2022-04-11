package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;

import java.time.LocalDateTime;

public interface ControleExecucaoFluxoService {

    Long recuperarTipoEntidade(ControleExecucaoFluxo controleExecucaoFluxo);

    void atualizarHora(ControleExecucaoFluxo controleExecucaoFluxo);
}
