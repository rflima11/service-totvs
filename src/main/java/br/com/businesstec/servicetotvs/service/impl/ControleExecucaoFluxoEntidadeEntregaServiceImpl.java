package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;
import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidadeEntrega;
import br.com.businesstec.model.repository.ControleExecucaoFluxoEntidadeEntregaRepository;
import br.com.businesstec.model.repository.ControleExecucaoFluxoEntidadeRepository;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoEntidadeEntregaService;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoEntidadeService;
import org.springframework.stereotype.Component;

@Component
public class ControleExecucaoFluxoEntidadeEntregaServiceImpl implements ControleExecucaoFluxoEntidadeEntregaService {

    private final ControleExecucaoFluxoEntidadeEntregaRepository repository;
    private final ControleExecucaoFluxoEntidadeRepository controleExecucaoFluxoEntidadeRepository;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;


    public ControleExecucaoFluxoEntidadeEntregaServiceImpl(ControleExecucaoFluxoEntidadeEntregaRepository repository, ControleExecucaoFluxoEntidadeRepository controleExecucaoFluxoEntidadeRepository, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.repository = repository;
        this.controleExecucaoFluxoEntidadeRepository = controleExecucaoFluxoEntidadeRepository;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
    }

    @Override
    public ControleExecucaoFluxoEntidadeEntrega registrarExecucao(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade) {
        controleExecucaoFluxoEntidadeService.atualizarIntegracao(controleExecucaoFluxoEntidade);
        return repository.save(new ControleExecucaoFluxoEntidadeEntrega(controleExecucaoFluxoEntidade.getId(), false));
    }

    @Override
    public ControleExecucaoFluxoEntidadeEntrega registrarErro(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade, String descricaoErro) {
        controleExecucaoFluxoEntidadeService.atualizarIntegracaoErro(controleExecucaoFluxoEntidade);
        return repository.save(new ControleExecucaoFluxoEntidadeEntrega(controleExecucaoFluxoEntidade.getId(), true, ""));
    }


}
