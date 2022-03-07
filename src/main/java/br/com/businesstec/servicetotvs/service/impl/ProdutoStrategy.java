package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.NomeStrategy;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import org.springframework.stereotype.Service;

@Service
public class ProdutoStrategy implements EntidadeStrategy {

    @Override
    public void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO) {

    }

    @Override
    public NomeStrategy getNomeStrategy() {
        return NomeStrategy.PRODUTO_STRATEGY;
    }
}
