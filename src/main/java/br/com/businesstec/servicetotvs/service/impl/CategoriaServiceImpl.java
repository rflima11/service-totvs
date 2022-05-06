package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.Categoria;
import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.repository.CategoriaRepository;
import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.mapper.CategoriaEcommerceMapper;
import br.com.businesstec.servicetotvs.mapper.CategoriaMapper;
import br.com.businesstec.servicetotvs.service.CategoriaService;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ConsultaSqlService consultaSqlService;
    private final CategoriaEcommerceMapper categoriaMapper;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, ConsultaSqlService consultaSqlService) {
        this.categoriaRepository = categoriaRepository;
        this.consultaSqlService = consultaSqlService;
        this.categoriaMapper = CategoriaEcommerceMapper.INSTANCE;
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        var categoriaOpcional = categoriaRepository.findByIdentificadorOrigem(categoria.getIdentificadorOrigem());
        if (categoriaOpcional.isPresent()) {
            var categoriaSalva = categoriaOpcional.get();
            categoria.setId(categoriaSalva.getId());
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public void salvarCategoriasByIdProduto(ControleExecucaoFluxo controleExecucaoFluxo, String identificadorOrigem) {
        var request = ConsultaSimpleFactory.getParametrosConsulta(controleExecucaoFluxo.getDataHora(), EntidadeEnum.CATEGORIA_POR_PRODUTO.getValue());
        request.adicionarParametro(EnumParametersSoap.ID_PRODUTO, identificadorOrigem);

        var response = consultaSqlService.realizaConsulta(request);

        if (Objects.nonNull(response.getResultados())) {
            response.getResultados().forEach(resultado -> {
                var categoria = categoriaMapper.map(resultado);
                System.out.println(categoria);
            });
        }
    }
}
