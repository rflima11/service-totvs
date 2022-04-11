package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxoEntidade;
import br.com.businesstec.servicetotvs.repository.ControleExecucaoFluxoEntidadeRepository;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoEntidadeService;
import org.springframework.stereotype.Service;

@Service
public class ControleExecucaoFluxoEntidadeServiceImpl implements ControleExecucaoFluxoEntidadeService {

    private final ControleExecucaoFluxoEntidadeRepository repository;

    public ControleExecucaoFluxoEntidadeServiceImpl(ControleExecucaoFluxoEntidadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ControleExecucaoFluxoEntidade registrar(Long idControleExecucaoFluxo, Long idEntidade) {
       return repository.save(new ControleExecucaoFluxoEntidade(idControleExecucaoFluxo, idEntidade));
    }
}
