package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.mapper.ProdutoEcommerceMapper;
import br.com.businesstec.servicetotvs.mapper.ProdutoMapper;
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
    private final CategoriaEcommerceService categoriaEcommerceService;
    private final ProdutoCategoriaService produtoCategoriaService;

    public ProdutoStrategy(EntidadeService entidadeService, ProdutoService produtoService, ProdutoEcommerceService produtoEcommerceService, ProdutoSkuService produtoSkuService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService, CategoriaEcommerceService categoriaEcommerceService, ProdutoCategoriaService produtoCategoriaService) {
        this.entidadeService = entidadeService;
        this.produtoService = produtoService;
        this.produtoEcommerceService = produtoEcommerceService;
        this.produtoSkuService = produtoSkuService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.categoriaEcommerceService = categoriaEcommerceService;
        this.produtoCategoriaService = produtoCategoriaService;
        produtoMapper = ProdutoMapper.INSTANCE;
        produtoEcommerceMapper = ProdutoEcommerceMapper.INSTANCE;
    }

    @Override
    public void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var produtos = realizarConsultaSQLResponseDTO.getResultados();
        
        produtos.stream().forEach(p -> {
            var produto = produtoMapper.map(p);
            var produtoSalvo = produtoService.salvar(produto);
            var produtoEcommerce = produtoEcommerceMapper.map(p);
            produtoEcommerce.setIdProduto(produto.getId());
            controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), produtoSalvo.getIdEntidade());
            produtoCategoriaService.buscarCategoriasPorProdutos(controleExecucaoFluxo, produtoSalvo.getIdentificadorOrigem());
            produtoEcommerceService.salvar(produtoEcommerce);

//          produtoSkuService.salvarProdutosSkuByIdProduto(controleExecucaoFluxo, produto.getIdentificadorOrigem());
        });

    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.PRODUTO_STRATEGY;
    }
}
