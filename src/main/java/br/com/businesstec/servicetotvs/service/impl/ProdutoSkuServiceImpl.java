package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ProdutoSku;
import br.com.businesstec.model.repository.ProdutoSkuRepository;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.mapper.ProdutoSkuMapper;
import br.com.businesstec.servicetotvs.service.*;
import org.springframework.stereotype.Service;

@Service
public class ProdutoSkuServiceImpl implements ProdutoSkuService {

    private final ProdutoSkuRepository produtoSkuRepository;
    private final ProdutoService produtoService;
    private final EntidadeService entidadeService;
    private final ConsultaSqlService consultaSqlService;
    private final ProdutoSkuMapper mapper;
    private final VariacaoProdutoSkuService variacaoProdutoSkuService;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;

    public ProdutoSkuServiceImpl(ProdutoSkuRepository produtoSkuRepository, ProdutoService produtoService, EntidadeService entidadeService, ConsultaSqlService consultaSqlService, VariacaoProdutoSkuService variacaoProdutoSkuService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.produtoSkuRepository = produtoSkuRepository;
        this.produtoService = produtoService;
        this.entidadeService = entidadeService;
        this.consultaSqlService = consultaSqlService;
        this.variacaoProdutoSkuService = variacaoProdutoSkuService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.mapper = ProdutoSkuMapper.INSTANCE;
    }

    @Override
    public ProdutoSku salvar(ProdutoSku produtoSku) {
        produtoSku.setIdEntidade(entidadeService.salvar(EnumTipoEntidade.PRODUTO_SKU).getId());
        return produtoSkuRepository.save(produtoSku);
    }
}
