package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.ProdutoCategoria;
import br.com.businesstec.model.repository.ProdutoCategoriaRepository;
import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.mapper.CategoriaProdutoMapper;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.ProdutoCategoriaService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProdutoCategoriaServiceImpl implements ProdutoCategoriaService {

    private final ProdutoCategoriaRepository produtoCategoriaRepository;
    private final ConsultaSqlService consultaSqlService;
    private final CategoriaProdutoMapper mapper;

    public ProdutoCategoriaServiceImpl(ProdutoCategoriaRepository produtoCategoriaRepository, ConsultaSqlService consultaSqlService) {
        this.produtoCategoriaRepository = produtoCategoriaRepository;
        this.consultaSqlService = consultaSqlService;
        mapper = CategoriaProdutoMapper.INSTANCE;
    }

    @Override
    public ProdutoCategoria salvar(ProdutoCategoria produtoCategoria) {
        var listProdutoCategoria = produtoCategoriaRepository.findByIdProduto(produtoCategoria.getIdProduto());
        var optProdutoCatSalvo = listProdutoCategoria.stream().filter(x -> x.getIdCategoria().equals(produtoCategoria.getIdCategoria())).findFirst();
        if (optProdutoCatSalvo.isPresent()) {
            var produtoCatSalvo = optProdutoCatSalvo.get();
            produtoCategoria.setId(produtoCatSalvo.getId());
        }
        return produtoCategoriaRepository.save(produtoCategoria);
    }

    @Override
    public void buscarCategoriasPorProdutos(ControleExecucaoFluxo controleExecucaoFluxo, String externalIdProduto) {
        var request = ConsultaSimpleFactory.getParametrosConsulta(controleExecucaoFluxo.getDataHora(), EntidadeEnum.CATEGORIA_POR_PRODUTO.getValue());
        request.adicionarParametro(EnumParametersSoap.ID_PRODUTO, externalIdProduto);

        var response = consultaSqlService.realizaConsulta(request);

        if (Objects.nonNull(response.getResultados())) {
            response.getResultados().forEach(resultado -> {
                var categoria = mapper.map(resultado);
                this.salvar(categoria);
            });
        }
    }
}

