package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.VariacaoProdutoSku;
import br.com.businesstec.model.repository.VariacaoProdutoSkuRepository;
import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.mapper.VariacaoSkuProdutoMapper;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.VariacaoProdutoSkuService;
import org.springframework.stereotype.Service;

@Service
public class VariacaoProdutoSkuServiceImpl implements VariacaoProdutoSkuService {

    private final VariacaoProdutoSkuRepository repository;
    private final ConsultaSqlService consultaSqlService;
    private final VariacaoSkuProdutoMapper mapper;

    public VariacaoProdutoSkuServiceImpl(VariacaoProdutoSkuRepository repository, ConsultaSqlService consultaSqlService) {
        this.repository = repository;
        this.consultaSqlService = consultaSqlService;
        mapper = VariacaoSkuProdutoMapper.INSTANCE;
    }

    private VariacaoProdutoSku save(VariacaoProdutoSku variacaoProdutoSku) {
        var optionalVariacaoProduto = repository.findByIdProdutoSku(variacaoProdutoSku.getIdProdutoSku());
        if (optionalVariacaoProduto.isPresent()) {
            var variacaoSalva = optionalVariacaoProduto.get();
            variacaoProdutoSku.setId(variacaoSalva.getId());
        }
        return repository.save(variacaoProdutoSku);
    }

    @Override
    public void salvarVariacaoProdutoSku(ControleExecucaoFluxo controleExecucaoFluxo, Long idProdutoSku) {
        var parametros = ConsultaSimpleFactory.getParametrosConsulta(controleExecucaoFluxo.getDataHora(), EntidadeEnum.PRODUTO_SKU_VARIACOES.getValue());
        parametros.adicionarParametro(EnumParametersSoap.ID_PRODUTO_SKU_VARIACAO, idProdutoSku.toString());
        var response = consultaSqlService.realizaConsulta(parametros);
        var resultados = response.getResultados();

        resultados.stream().forEach(varicaoProduto -> {
            var variacaoProdutoModel = mapper.map(varicaoProduto);
            this.save(variacaoProdutoModel);
        });
    }


    private VariacaoProdutoSku recuperarVariacaoSkuById(Long idProdutoSku) {
        return repository.findByIdProdutoSku(idProdutoSku).orElseThrow(() -> new RuntimeException("Variação não encontrada"));
    }
}
