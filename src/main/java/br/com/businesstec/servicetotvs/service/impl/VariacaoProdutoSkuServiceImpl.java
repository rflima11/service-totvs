package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.VariacaoProdutoSku;
import br.com.businesstec.model.repository.VariacaoProdutoSkuRepository;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.enums.ConsultaParametrosEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.mapper.VariacaoSkuProdutoMapper;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.VariacaoProdutoSkuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    private VariacaoProdutoSku salvar(VariacaoProdutoSku variacaoProdutoSku) {
        return repository.save(variacaoProdutoSku);
    }

    @Override
    public void salvarVariacaoProdutoSku(ControleExecucaoFluxo controleExecucaoFluxo, Long idProdutoSku, Long idEntidade) {
        var parametros = new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_PRODUTO_SKU_VARIACOES.getValue());
        parametros.adicionarDataSinc(controleExecucaoFluxo.getDataHora());
        parametros.adicionarParametro(EnumParametersSoap.ID_PRODUTO_SKU_VARIACAO, idProdutoSku.toString());
        var response = consultaSqlService.realizaConsulta(parametros);
        var resultados = response.getResultados();

        if (Objects.nonNull(resultados)) {
            resultados.stream().forEach(varicaoProduto -> {
                var variacaoProdutoModel = mapper.map(varicaoProduto);
                variacaoProdutoModel.setIdProdutoSku(idEntidade);
                this.salvar(variacaoProdutoModel);
            });
        }

    }


    private List<VariacaoProdutoSku> recuperarVariacaoSkuById(Long idProdutoSku) {
        return repository.findByIdProdutoSku(idProdutoSku);
    }
}
