package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import org.springframework.stereotype.Service;

@Service
public class ProdutoSkuStrategy implements EntidadeStrategy {



    @Override
    public void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {

    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return null;
    }
}
