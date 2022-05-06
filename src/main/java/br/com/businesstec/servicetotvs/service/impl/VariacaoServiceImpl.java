package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.Variacao;
import br.com.businesstec.model.repository.VariacaoItemRepository;
import br.com.businesstec.model.repository.VariacaoRepository;
import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.mapper.VariacaoItemMapper;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.VariacaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VariacaoServiceImpl implements VariacaoService {

    private final VariacaoRepository variacaoRepository;
    private final VariacaoItemRepository variacaoItemRepository;
    private final ConsultaSqlService consultaSqlService;
    private final VariacaoItemMapper variacaoItemMapper;

    public VariacaoServiceImpl(VariacaoRepository variacaoRepository, VariacaoItemRepository variacaoItemRepository, ConsultaSqlService consultaSqlService) {
        this.variacaoRepository = variacaoRepository;
        this.variacaoItemRepository = variacaoItemRepository;
        this.consultaSqlService = consultaSqlService;
        variacaoItemMapper = VariacaoItemMapper.INSTANCE;
    }

    @Override
    public List<Variacao> encontrarVariacaoPeloIdentificadorOrigem(String identificadorOrigem) {
        return variacaoRepository.findByIdentificadorOrigem(identificadorOrigem);
    }

    @Override
    public List<Variacao> encontrarTodasVariacoes() {
        return variacaoRepository.findAll();
    }

    @Override
    public void salvarVariacoesItem(ControleExecucaoFluxo controleExecucaoFluxo, String externalId, Long idVariacao) {
        var request = ConsultaSimpleFactory.getParametrosConsulta(controleExecucaoFluxo.getDataHora(), EntidadeEnum.VARIACOES_ITEM.getValue());
        request.adicionarParametro(EnumParametersSoap.ID_VARIACAO, externalId);

        var response = consultaSqlService
                .realizaConsulta(request);


        if (Objects.nonNull(response.getResultados())) {

            response.getResultados().stream().forEach(variacaoTotvs -> {
                var variacaoItemModel = variacaoItemMapper.map(variacaoTotvs);

                if (variacaoItemRepository.existsByIdentificadorOrigem(variacaoTotvs.getExternalId())) {
                   var variacaoItem = variacaoItemRepository.findByIdentificadorOrigem(variacaoTotvs.getExternalId());
                   variacaoItemModel.setId(variacaoItem.getId());
                }
                variacaoItemModel.setIdVariacao(idVariacao);
                variacaoItemRepository.save(variacaoItemModel);
            });
        }

    }

    @Override
    public boolean isVariacaoSalva(ObjetoTOTVS objetoTOTVS) {
        return variacaoRepository.existsByIdentificadorOrigem(objetoTOTVS.getExternalId());
    }
}
