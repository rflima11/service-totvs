package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.repository.VariacaoItemRepository;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.mapper.VariacaoItemMapper;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoEntidadeService;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import br.com.businesstec.servicetotvs.service.VariacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class VariacaoItemStrategy implements EntidadeStrategy {

    private static final Logger logger = LoggerFactory.getLogger(VariacoesStrategy.class);

    private final VariacaoItemRepository variacaoItemRepository;
    private final VariacaoService variacaoService;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final EntidadeService entidadeService;
    private final VariacaoItemMapper mapper;

    public VariacaoItemStrategy(VariacaoItemRepository variacaoItemRepository, VariacaoService variacaoService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService, EntidadeService entidadeService) {
        this.variacaoItemRepository = variacaoItemRepository;
        this.variacaoService = variacaoService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.entidadeService = entidadeService;
        this.mapper = VariacaoItemMapper.INSTANCE;
    }

    @Override
    public void executar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var variacoes = variacaoService.encontrarTodasVariacoes();

            var variacaoItem = realizarConsultaSQLResponseDTO.getResultados();

            if(!variacoes.isEmpty()) {
                var variacoesModel = variacaoItem.stream().map(variacaoTotvs -> {
                    var entidade = entidadeService.salvar(EnumTipoEntidade.MARCA);
                    var variacaoModel = mapper.map(variacaoTotvs);
                    var variacao = variacaoService.encontrarVariacaoPeloIdentificadorOrigem(variacaoModel.getIdentificadorOrigem());
                    //variacaoModel.setIdVariacao(variacao.getId()); CHECAR DEPOIS
                    controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), entidade.getId());
                    return variacaoModel;
                }).collect(Collectors.toList());

                logger.info("=======================================================================");
                logger.info("REALIZANDO INSERÇÃO DE " + variacaoItem.size() + " VARIACÕES ITEM NO BANCO DE DADOS");
                logger.info("=======================================================================");

                variacaoItemRepository.saveAll(variacoesModel);
            }
    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.LISTA_VARIACAO_STRATEGY;
    }
}
