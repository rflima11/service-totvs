package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.CategoriaEcommerce;
import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.repository.CategoriaEcommerceRepository;
import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.mapper.CategoriaEcommerceMapper;
import br.com.businesstec.servicetotvs.service.CategoriaEcommerceService;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoriaEcommerceServiceImpl implements CategoriaEcommerceService {

    private final CategoriaEcommerceRepository categoriaEcommerceRepository;
    private final ConsultaSqlService consultaSqlService;
    private final CategoriaEcommerceMapper categoriaEcommerceMapper;

    public CategoriaEcommerceServiceImpl(CategoriaEcommerceRepository categoriaEcommerceRepository, ConsultaSqlService consultaSqlService) {
        this.categoriaEcommerceRepository = categoriaEcommerceRepository;
        this.consultaSqlService = consultaSqlService;
        categoriaEcommerceMapper = CategoriaEcommerceMapper.INSTANCE;
    }

    @Override
    public CategoriaEcommerce salvar(CategoriaEcommerce categoriaEcommerce) {
        var categoriaOptional = categoriaEcommerceRepository.findByIdCategoria(categoriaEcommerce.getIdCategoria());
        if (categoriaOptional.isPresent()) {
           var categoriaSalva =  categoriaOptional.get();
            categoriaEcommerce.setId(categoriaSalva.getId());
        }

        return categoriaEcommerceRepository.save(categoriaEcommerce);
    }

    @Override
    public void salvarCategoriasEcommerceByIdProduto(ControleExecucaoFluxo controleExecucaoFluxo, String identificadorOrigem) {
        var request = ConsultaSimpleFactory.getParametrosConsulta(controleExecucaoFluxo.getDataHora(), EntidadeEnum.CATEGORIA_POR_PRODUTO.getValue());
        request.adicionarParametro(EnumParametersSoap.ID_PRODUTO, identificadorOrigem);

        var response = consultaSqlService.realizaConsulta(request);

        if (Objects.nonNull(response.getResultados())) {
            response.getResultados().forEach(resultado -> {
                var categoria = categoriaEcommerceMapper.map(resultado);
                this.salvar(categoria);
            });
        }
    }
}
