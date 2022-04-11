package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.mapper.VariacaoMapper;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.repository.VariacaoRepository;
import br.com.businesstec.servicetotvs.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VariacoesStrategy implements EntidadeStrategy {

    private static final Logger logger = LoggerFactory.getLogger(VariacoesStrategy.class);

    private final VariacaoRepository variacaoRepository;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final VariacaoService variacaoService;
    private final EntidadeService entidadeService;
    private final VariacaoMapper variacaoMapper;

    public VariacoesStrategy(VariacaoRepository variacaoRepository,
                             ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService,
                             VariacaoService variacaoService,
                             EntidadeService entidadeService) {
        this.variacaoRepository = variacaoRepository;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.variacaoService = variacaoService;
        this.entidadeService = entidadeService;
        this.variacaoMapper = VariacaoMapper.INSTANCE;
    }

    @Override
    public void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var variacoes = realizarConsultaSQLResponseDTO.getResultados();

        variacoes.stream().forEach(variacaoTotvs -> {
            var variacaoModel = variacaoMapper.map(variacaoTotvs);

            if (!variacaoService.isVariacaoSalva(variacaoTotvs)) {
                var entidade = entidadeService.salvar(EnumTipoEntidade.MARCA);
                    controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), entidade.getId());
                variacaoModel.setIdEntidade(entidade.getId());
            } else {
                var variacaoSalva = variacaoRepository.findByIdentificadorOrigem(variacaoTotvs.getExternalId());
                variacaoModel.setId(variacaoSalva.getId());
                variacaoModel.setIdEntidade(variacaoSalva.getIdEntidade());
            }
            var variacao = variacaoRepository.save(variacaoModel);
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
