package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.mapper.ProdutoEcommerceMapper;
import br.com.businesstec.servicetotvs.mapper.ProdutoMapper;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.service.*;
import org.springframework.stereotype.Service;

@Service
public class ProdutoStrategy implements EntidadeStrategy {
    
    private final ProdutoMapper produtoMapper;
    private final ProdutoEcommerceMapper produtoEcommerceMapper;
    private final EntidadeService entidadeService;
    private final ProdutoService produtoService;
    private final ProdutoEcommerceService produtoEcommerceService;
    private final ProdutoSkuService produtoSkuService;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;

    public ProdutoStrategy(EntidadeService entidadeService, ProdutoService produtoService, ProdutoEcommerceService produtoEcommerceService, ProdutoSkuService produtoSkuService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.entidadeService = entidadeService;
        this.produtoService = produtoService;
        this.produtoEcommerceService = produtoEcommerceService;
        this.produtoSkuService = produtoSkuService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        produtoMapper = ProdutoMapper.INSTANCE;
        produtoEcommerceMapper = ProdutoEcommerceMapper.INSTANCE;
    }

    @Override
    public void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var produtos = realizarConsultaSQLResponseDTO.getResultados();
        
        produtos.stream().forEach(p -> {
            var entidade = entidadeService.salvar(EnumTipoEntidade.PRODUTO);
            var produto = produtoMapper.map(p);
            produto.setIdEntidade(entidade.getId());
            produtoService.salvar(produto);
            var produtoEcommerce = produtoEcommerceMapper.map(p);
            produtoEcommerce.setIdProduto(produto.getId());
            controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), entidade.getId());
            produtoEcommerceService.salvar(produtoEcommerce);
            produtoSkuService.salvarProdutosSkuByIdProduto(controleExecucaoFluxo, produto.getIdentificadorOrigem());
        });

    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.PRODUTO_STRATEGY;
    }
}
