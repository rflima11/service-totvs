package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.mapper.MarcaMapper;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MarcaStrategy implements EntidadeStrategy {

    private static final Logger logger = LoggerFactory.getLogger(MarcaStrategy.class);

    private final MarcaEcommerceService marcaEcommerceService;
    private final MarcaService marcaService;
    private final EntidadeService entidadeService;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final MarcaMapper marcaMapper;

    public MarcaStrategy(MarcaEcommerceService marcaEcommerceService, MarcaService marcaService, EntidadeService entidadeService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.marcaEcommerceService = marcaEcommerceService;
        this.marcaService = marcaService;
        this.entidadeService = entidadeService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.marcaMapper = MarcaMapper.INSTANCE;
    }

    @Override
    public void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var marcas = realizarConsultaSQLResponseDTO.getResultados();

        marcas.stream().forEach(marcaTotvs -> {
            var entidade = entidadeService.salvar(EnumTipoEntidade.MARCA);
            var marca = marcaService.salvar(entidade.getId(), marcaTotvs.getExternalId(), marcaTotvs.getName());
            var marcaModel = marcaMapper.map(marcaTotvs);
            controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), entidade.getId());
            marcaModel.setIdMarca(marca.getId());
            marcaEcommerceService.salvar(marcaModel);
        });

        logger.info("=======================================================================");
        logger.info("REALIZANDO INSERÇÃO DE " + marcas.size() + " MARCAS NO BANCO DE DADOS");
        logger.info("=======================================================================");

    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.MARCA_STRATEGY;
    }
}
