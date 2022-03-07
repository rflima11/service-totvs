package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxoTentativa;

public interface ControleExecucaoFluxoTentativaService {

    ControleExecucaoFluxoTentativa registrarNovaTentativa(ControleExecucaoFluxo controleExecucaoFluxo);
}
