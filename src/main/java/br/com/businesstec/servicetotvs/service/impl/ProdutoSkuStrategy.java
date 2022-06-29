package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.mapper.ProdutoSkuEcommerceMapper;
import br.com.businesstec.servicetotvs.mapper.ProdutoSkuMapper;
import br.com.businesstec.servicetotvs.service.*;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProdutoSkuStrategy implements EntidadeStrategy {

    private final ProdutoService produtoService;
    private final ProdutoSkuService produtoSkuService;
    private final ProdutoSkuEcommerceService produtoSkuEcommerceService;
    private final VariacaoProdutoSkuService variacaoProdutoSku;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final ProdutoSkuMapper mapper;
    private final ProdutoSkuEcommerceMapper ecommerceMapper;

    public ProdutoSkuStrategy(ProdutoService produtoService, ProdutoSkuService produtoSkuService, ProdutoSkuEcommerceService produtoSkuEcommerceService, VariacaoProdutoSkuService variacaoProdutoSku, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.produtoService = produtoService;
        this.produtoSkuService = produtoSkuService;
        this.produtoSkuEcommerceService = produtoSkuEcommerceService;
        this.variacaoProdutoSku = variacaoProdutoSku;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.ecommerceMapper = ProdutoSkuEcommerceMapper.INSTANCE;
        mapper = ProdutoSkuMapper.INSTANCE;
    }

    @Override
    public void executar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {

        if (Objects.nonNull(realizarConsultaSQLResponseDTO.getResultados())) {
            realizarConsultaSQLResponseDTO.getResultados().forEach(resultado -> {
                var produtoSku = mapper.map(resultado);
                produtoSku.setIdentificadorOrigem(String.valueOf(resultado.getId()));
                var produtoSkuSalvo = produtoSkuService.salvar(produtoSku);
                var produtoSkuEcommerce = ecommerceMapper.map(resultado);
                produtoSkuEcommerce.setIdProdutoSku(produtoSkuSalvo.getId());
                produtoSkuEcommerceService.salvar(produtoSkuEcommerce);
                variacaoProdutoSku.salvarVariacaoProdutoSku(controleExecucaoFluxo, Long.valueOf(produtoSkuSalvo.getIdentificadorOrigem()));
                controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), produtoSkuSalvo.getIdEntidade());
            });
        }
    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.SKU_STRATEGY;
    }
}
