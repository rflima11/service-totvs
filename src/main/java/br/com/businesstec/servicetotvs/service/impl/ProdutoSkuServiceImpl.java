package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.ProdutoSku;
import br.com.businesstec.model.repository.ProdutoSkuRepository;
import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.mapper.ProdutoSkuMapper;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import br.com.businesstec.servicetotvs.service.ProdutoService;
import br.com.businesstec.servicetotvs.service.ProdutoSkuService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProdutoSkuServiceImpl implements ProdutoSkuService {

    private final ProdutoSkuRepository produtoSkuRepository;
    private final ProdutoService produtoService;
    private final EntidadeService entidadeService;
    private final ConsultaSqlService consultaSqlService;
    private final ProdutoSkuMapper mapper;

    public ProdutoSkuServiceImpl(ProdutoSkuRepository produtoSkuRepository, ProdutoService produtoService, EntidadeService entidadeService, ConsultaSqlService consultaSqlService) {
        this.produtoSkuRepository = produtoSkuRepository;
        this.produtoService = produtoService;
        this.entidadeService = entidadeService;
        this.consultaSqlService = consultaSqlService;
        this.mapper = ProdutoSkuMapper.INSTANCE;
    }

    @Override
    public void salvarProdutosSkuByIdProduto(ControleExecucaoFluxo controleExecucaoFluxo, String idProduto) {
        var request = ConsultaSimpleFactory.getParametrosConsulta(controleExecucaoFluxo.getDataHora(), EntidadeEnum.PRODUTO_SKU.getValue());
        request.adicionarParametro(EnumParametersSoap.ID_PRODUTO, idProduto);

        var response = consultaSqlService.realizaConsulta(request);

        if (Objects.nonNull(response.getResultados())) {
            response.getResultados().forEach(resultado -> {
                var produtoSku = mapper.map(resultado);
                produtoSku.setIdProduto(produtoService.findByIdentificadorOrigem(idProduto).getId());
                produtoSku.setIdentificadorOrigem(String.valueOf(resultado.getId()));
                this.salvar(produtoSku);
            });
        }

    }

    private ProdutoSku salvar(ProdutoSku produtoSku) {
        var optionalProdutoSku = produtoSkuRepository.findByIdentificadorOrigem(produtoSku.getIdentificadorOrigem());

        if (optionalProdutoSku.isPresent()) {
            var produtoSkuSalvo = optionalProdutoSku.get();
            produtoSku.setId(produtoSkuSalvo.getId());
        } else {
            produtoSku.setId(null);
        }
        produtoSku.setIdEntidade(entidadeService.salvar(EnumTipoEntidade.PRODUTO_SKU).getId());
        return produtoSkuRepository.save(produtoSku);
    }
}
