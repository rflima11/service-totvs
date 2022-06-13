package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.Variacao;
import br.com.businesstec.model.repository.VariacaoRepository;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.mapper.VariacaoMapper;
import br.com.businesstec.servicetotvs.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VariacoesStrategy implements EntidadeStrategy {

    private static final Logger logger = LoggerFactory.getLogger(VariacoesStrategy.class);

    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final VariacaoService variacaoService;
    private final VariacaoMapper variacaoMapper;

    public VariacoesStrategy(ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService,
                             VariacaoService variacaoService) {
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.variacaoService = variacaoService;
        this.variacaoMapper = VariacaoMapper.INSTANCE;
    }

    @Override
    public void executar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var variacoes = realizarConsultaSQLResponseDTO.getResultados();

        variacoes.stream().forEach(variacaoTotvs -> {
            var variacaoModel = variacaoMapper.map(variacaoTotvs);
            var variacao = variacaoService.salvar(variacaoModel);
            controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), variacao.getIdEntidade());
            variacaoService.salvarVariacoesItem(controleExecucaoFluxo, variacaoTotvs.getExternalId(), variacao.getId());
        });

        logger.info("=======================================================================");
        logger.info("REALIZANDO INSERÇÃO DE " + variacoes.size() + " VARIACÕES NO BANCO DE DADOS");
        logger.info("=======================================================================");

    }


    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.VARIACAO_STRATEGY;
    }
}
