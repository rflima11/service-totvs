package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.Variacao;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;

import java.util.List;

public interface VariacaoService {

    List<Variacao> encontrarVariacaoPeloIdentificadorOrigem(String identificadorOrigem);

    List<Variacao> encontrarTodasVariacoes();

    void salvarVariacoesItem(ControleExecucaoFluxo controleExecucaoFluxo, String externalId, Long idVariacao);

    boolean isVariacaoSalva(ObjetoTOTVS objetoTOTVS);

}
