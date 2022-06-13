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
        var optControleExecucaoFluxo = repository.findByIdEntidade(idEntidade);
        var controleExecucaoFluxoEntidade = new ControleExecucaoFluxoEntidade(idControleExecucaoFluxo, idEntidade);
        if (optControleExecucaoFluxo.isPresent())  {
            controleExecucaoFluxoEntidade.setId(optControleExecucaoFluxo.get().getId());
        }
        repository.save(controleExecucaoFluxoEntidade);
    }

    @Override
    public ControleExecucaoFluxoEntidade atualizarIntegracao(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade) {
        controleExecucaoFluxoEntidade.setIntegrado(true);
        return repository.save(controleExecucaoFluxoEntidade);
    }

    @Override
    public ControleExecucaoFluxoEntidade atualizarIntegracaoErro(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade) {
        controleExecucaoFluxoEntidade.setIntegrado(false);
        return repository.save(controleExecucaoFluxoEntidade);    }


}
