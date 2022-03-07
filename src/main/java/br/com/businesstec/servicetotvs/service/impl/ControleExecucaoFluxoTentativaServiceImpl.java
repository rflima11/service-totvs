package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxoTentativa;
import br.com.businesstec.servicetotvs.repository.ControleExecucaoFluxoTentativaRepository;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoTentativaService;
import org.springframework.stereotype.Service;

@Service
public class ControleExecucaoFluxoTentativaServiceImpl implements ControleExecucaoFluxoTentativaService {

    private final ControleExecucaoFluxoTentativaRepository controleExecucaoFluxoTentativaRepository;

    public ControleExecucaoFluxoTentativaServiceImpl(ControleExecucaoFluxoTentativaRepository controleExecucaoFluxoTentativaRepository) {
        this.controleExecucaoFluxoTentativaRepository = controleExecucaoFluxoTentativaRepository;
    }

    @Override
    public ControleExecucaoFluxoTentativa registrarNovaTentativa(ControleExecucaoFluxo controleExecucaoFluxo) {
        return controleExecucaoFluxoTentativaRepository.save(new ControleExecucaoFluxoTentativa(controleExecucaoFluxo.getId()));
    }
}
