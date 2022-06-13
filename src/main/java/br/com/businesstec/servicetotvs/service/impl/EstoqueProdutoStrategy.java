package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.mapper.EstoqueProdutoMapper;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoEntidadeService;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import br.com.businesstec.servicetotvs.service.EstoqueProdutoService;
import org.springframework.stereotype.Service;

@Service
public class EstoqueProdutoStrategy implements EntidadeStrategy {

    private final EstoqueProdutoService estoqueProdutoService;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final EstoqueProdutoMapper mapper;

    public EstoqueProdutoStrategy(EstoqueProdutoService estoqueProdutoService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.estoqueProdutoService = estoqueProdutoService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        mapper = EstoqueProdutoMapper.INSTANCE;
    }

    @Override
    public void executar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var resultados = realizarConsultaSQLResponseDTO.getResultados();

        resultados.stream().forEach(estoquePrd -> {
            var estoquePrdModel = mapper.map(estoquePrd);
            var estoquePrdSalvo = estoqueProdutoService.salvar(estoquePrdModel);
            controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), estoquePrdSalvo.getIdEntidade());
        });
    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.ESTOQUE_PRODUTO;
    }
}
