package br.com.businesstec.servicetotvs.events;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;
import org.springframework.context.ApplicationEvent;

public class ControleExecucaoFluxoEventJet extends ApplicationEvent {

    private ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade;

    public ControleExecucaoFluxoEventJet(Object source, ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade) {
        super(controleExecucaoFluxoEntidade);
        this.controleExecucaoFluxoEntidade = controleExecucaoFluxoEntidade;
    }

    public ControleExecucaoFluxoEntidade getControleExecucaoFluxoEntidade() {
        return controleExecucaoFluxoEntidade;
    }
}
