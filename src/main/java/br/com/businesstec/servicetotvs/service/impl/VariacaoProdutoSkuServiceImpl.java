package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.VariacaoProdutoSku;
import br.com.businesstec.model.repository.VariacaoProdutoSkuRepository;
import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.mapper.VariacaoSkuProdutoMapper;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.VariacaoProdutoSkuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        var variacoesPrdSku = repository.findByIdProdutoSku(variacaoProdutoSku.getIdProdutoSku());
        if (!variacoesPrdSku.isEmpty()) {
            var variacao = variacoesPrdSku.stream().filter(v -> {
                return v.getIdVariacaoItem().equals(variacaoProdutoSku.getIdVariacaoItem());
            }).findFirst();

            if (variacao.isPresent()) {
                variacaoProdutoSku.setId(variacao.get().getId());
            }
        }
        return repository.save(variacaoProdutoSku);
    }

    @Override
    public void salvarVariacaoProdutoSku(ControleExecucaoFluxo controleExecucaoFluxo, Long idProdutoSku, Long idEntidade) {
        var parametros = ConsultaSimpleFactory.getParametrosConsulta(controleExecucaoFluxo.getDataHora(), EntidadeEnum.PRODUTO_SKU_VARIACOES.getValue());
        parametros.adicionarParametro(EnumParametersSoap.ID_PRODUTO_SKU_VARIACAO, idProdutoSku.toString());
        var response = consultaSqlService.realizaConsulta(parametros);
        var resultados = response.getResultados();

        if (Objects.nonNull(resultados)) {
            resultados.stream().forEach(varicaoProduto -> {
                var variacaoProdutoModel = mapper.map(varicaoProduto);
                variacaoProdutoModel.setIdProdutoSku(idEntidade);
                this.save(variacaoProdutoModel);
            });
        }

    }


    private List<VariacaoProdutoSku> recuperarVariacaoSkuById(Long idProdutoSku) {
        return repository.findByIdProdutoSku(idProdutoSku);
    }
}
