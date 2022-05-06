package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;
import br.com.businesstec.model.repository.ControleExecucaoFluxoEntidadeRepository;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoEntidadeService;
import org.springframework.stereotype.Service;

@Service
public class ControleExecucaoFluxoEntidadeServiceImpl implements ControleExecucaoFluxoEntidadeService {

    private final ControleExecucaoFluxoEntidadeRepository repository;

    public ControleExecucaoFluxoEntidadeServiceImpl(ControleExecucaoFluxoEntidadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registrar(Long idControleExecucaoFluxo, Long idEntidade) {
        repository.save(new ControleExecucaoFluxoEntidade(idControleExecucaoFluxo, idEntidade));


    }
}
