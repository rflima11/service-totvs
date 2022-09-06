package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.mapper.CategoriaEcommerceMapper;
import br.com.businesstec.servicetotvs.mapper.CategoriaMapper;
import br.com.businesstec.servicetotvs.service.*;
import org.springframework.stereotype.Service;

@Service
public class CategoriaStrategy implements EntidadeStrategy {

    private final CategoriaService categoriaService;
    private final CategoriaEcommerceService categoriaEcommerceService;
    private final EntidadeService entidadeService;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final CategoriaMapper categoriaMapper;
    private final CategoriaEcommerceMapper categoriaEcommerceMapper;

    public CategoriaStrategy(CategoriaService categoriaService, CategoriaEcommerceService categoriaEcommerceService, EntidadeService entidadeService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.categoriaService = categoriaService;
        this.categoriaEcommerceService = categoriaEcommerceService;
        this.entidadeService = entidadeService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.categoriaMapper = CategoriaMapper.INSTANCE;
        this.categoriaEcommerceMapper = CategoriaEcommerceMapper.INSTANCE;
    }

    @Override
    public void executar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var categorias = realizarConsultaSQLResponseDTO.getResultados();

        categorias.stream().forEach(categoriaTotvs -> {
            var categoriaEcommerceModel = categoriaEcommerceMapper.map(categoriaTotvs);
            var categoriaModel = categoriaMapper.map(categoriaTotvs);
            var categoria = categoriaService.salvar(categoriaModel);
            categoriaEcommerceModel.setIdCategoria(categoria.getId());
            categoriaEcommerceService.salvar(categoriaEcommerceModel);
            controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), categoria.getIdEntidade());

        });
    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.CATEGORIA_STRATEGY;
    }
}
