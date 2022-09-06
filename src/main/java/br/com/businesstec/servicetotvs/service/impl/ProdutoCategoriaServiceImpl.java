package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.Produto;
import br.com.businesstec.model.entities.ProdutoCategoria;
import br.com.businesstec.model.repository.ProdutoCategoriaRepository;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.enums.ConsultaParametrosEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.mapper.CategoriaProdutoMapper;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.ProdutoCategoriaService;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public void salvar(ProdutoCategoria produtoCategoria, Produto produto) {
        produtoCategoria.setIdProduto(produto.getId());
        if (verificarSeJaFoiInserido(produtoCategoria.getIdProduto(), produtoCategoria.getIdCategoria())) {
            produtoCategoriaRepository.save(produtoCategoria);
        }
    }

    @Override
    public void buscarCategoriasPorProdutos(ControleExecucaoFluxo controleExecucaoFluxo, Produto produto) {
        var request = new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_CATEGORIAS_PARA_PRODUTOS.getValue());
        request.adicionarDataSinc(controleExecucaoFluxo.getDataHora());
        request.adicionarParametro(EnumParametersSoap.ID_PRODUTO, produto.getIdentificadorOrigem());

        var response = consultaSqlService.realizaConsulta(request);

        if (Objects.nonNull(response.getResultados())) {
            response.getResultados().forEach(resultado -> {
                var categoria = mapper.map(resultado);
                this.salvar(categoria, produto);
            });
        }
    }

    private Boolean verificarSeJaFoiInserido(Long idProduto, Long idCategoria) {
        var produtosCategoria = produtoCategoriaRepository.findByIdProduto(idProduto);
        return produtosCategoria.stream().noneMatch(p -> Objects.equals(p.getIdProduto(), idProduto) && Objects.equals(p.getIdCategoria(), idCategoria));
    }
}

