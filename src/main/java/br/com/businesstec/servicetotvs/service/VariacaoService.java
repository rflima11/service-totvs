package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.model.entidades.Variacao;

import java.util.List;

public interface VariacaoService {

    Variacao encontrarVariacaoPeloIdentificadorOrigem(String identificadorOrigem);

    List<Variacao> encontrarTodasVariacoes();

    void salvarVariacoesItem(ControleExecucaoFluxo controleExecucaoFluxo, String externalId, Long idVariacao);

    boolean isVariacaoSalva(ObjetoTOTVS objetoTOTVS);

}
