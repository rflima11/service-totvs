package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.repository.ControleExecucaoFluxoRepository;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ControleExecucaoFluxoServiceImpl implements ControleExecucaoFluxoService {

    private final ControleExecucaoFluxoRepository controleExecucaoFluxoTentativaRepository;

    public ControleExecucaoFluxoServiceImpl(ControleExecucaoFluxoRepository controleExecucaoFluxoTentativaRepository) {
        this.controleExecucaoFluxoTentativaRepository = controleExecucaoFluxoTentativaRepository;
    }

    @Override
    public Long recuperarTipoEntidade(ControleExecucaoFluxo controleExecucaoFluxo) {
        return controleExecucaoFluxoTentativaRepository.findIdTipoEntidadeByIdCtrlExecucaoFluxo(controleExecucaoFluxo.getId());
    }

    @Override
    public void atualizarHora(ControleExecucaoFluxo controleExecucaoFluxo) {
        controleExecucaoFluxo.atualizarHora();
        controleExecucaoFluxoTentativaRepository.save(controleExecucaoFluxo);
    }
}
