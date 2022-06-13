package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.repository.ControleExecucaoFluxoRepository;
import br.com.businesstec.model.repository.ControleFluxoRepository;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoService;
import org.springframework.stereotype.Service;

@Service
public class ControleExecucaoFluxoServiceImpl implements ControleExecucaoFluxoService {

    private final ControleExecucaoFluxoRepository controleExecucaoFluxoRepository;
    private final ControleFluxoRepository controleFluxoRepository;

    public ControleExecucaoFluxoServiceImpl(ControleExecucaoFluxoRepository controleExecucaoFluxoTentativaRepository, ControleFluxoRepository controleFluxoRepository) {
        this.controleExecucaoFluxoRepository = controleExecucaoFluxoTentativaRepository;
        this.controleFluxoRepository = controleFluxoRepository;
    }

    @Override
    public Long recuperarTipoEntidade(ControleExecucaoFluxo controleExecucaoFluxo) {
        var optionalControleFluxo = controleFluxoRepository.findById(controleExecucaoFluxo.getIdControleFluxo());

        if (optionalControleFluxo.isPresent()) {
            var controleFluxo = optionalControleFluxo.get();
            return controleFluxo.getIdTipoEntidade();
        }
        throw new RuntimeException("Tipo de entidade não encontrada");
    }

    @Override
    public void atualizarHora(ControleExecucaoFluxo controleExecucaoFluxo) {
        controleExecucaoFluxo.atualizarHora();
        controleExecucaoFluxoRepository.save(controleExecucaoFluxo);
    }

    @Override
    public ControleExecucaoFluxo encontrarPeloId(Long idControleExecucaoFluxo) {
        return controleExecucaoFluxoRepository.findById(idControleExecucaoFluxo).orElseThrow(() -> new RuntimeException("Não encontrado controle execucao fluxo com o ID: " + idControleExecucaoFluxo));
    }
}
