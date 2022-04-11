package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.mapper.ProdutoSkuMapper;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.model.entidades.ProdutoSku;
import br.com.businesstec.servicetotvs.repository.ProdutoSkuRepository;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.ProdutoSkuService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProdutoSkuServiceImpl implements ProdutoSkuService {

    private final ProdutoSkuRepository produtoSkuRepository;
    private final ConsultaSqlService consultaSqlService;
    private final ProdutoSkuMapper mapper;

    public ProdutoSkuServiceImpl(ProdutoSkuRepository produtoSkuRepository, ConsultaSqlService consultaSqlService) {
        this.produtoSkuRepository = produtoSkuRepository;
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
                this.salvar(produtoSku);
            });
        }

    }

    private ProdutoSku salvar(ProdutoSku produtoSku) {
        var optionalProdutoSku = produtoSkuRepository.findByIdProduto(produtoSku.getIdProduto());
        if (optionalProdutoSku.isPresent()) {
            var produtoSkuSalvo = optionalProdutoSku.get();
            produtoSku.setId(produtoSkuSalvo.getId());
        }
        return produtoSkuRepository.save(produtoSku);
    }
}
