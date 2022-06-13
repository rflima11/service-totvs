package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.mapper.PrecoProdutoMapper;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoEntidadeService;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import br.com.businesstec.servicetotvs.service.PrecoProdutoService;
import org.springframework.stereotype.Service;

@Service
public class PrecoProdutoStrategy implements EntidadeStrategy {

    private final PrecoProdutoService produtoService;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final PrecoProdutoMapper mapper;

    public PrecoProdutoStrategy(PrecoProdutoService produtoService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.produtoService = produtoService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        mapper = PrecoProdutoMapper.INSTANCE;
    }

    @Override
    public void executar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var resultados = realizarConsultaSQLResponseDTO.getResultados();

        resultados.stream().forEach(prcProduto -> {
            var prcProdutoModel = mapper.map(prcProduto);
            var prcProdutoSalvo = produtoService.salvar(prcProdutoModel);
            controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), prcProdutoSalvo.getId());
        });
    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.PRECO_PRODUTO;
    }
}
