package br.com.businesstec.servicetotvs.events;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import org.springframework.context.ApplicationEvent;

public class ControleExecucaoFluxoEvent extends ApplicationEvent {

    private ControleExecucaoFluxo controleExecucaoFluxo;

    public ControleExecucaoFluxoEvent(Object source, ControleExecucaoFluxo controleExecucaoFluxo) {
        super(controleExecucaoFluxo);
        this.controleExecucaoFluxo = controleExecucaoFluxo;
    }

    public ControleExecucaoFluxo getControleExecucaoFluxo() {
        return controleExecucaoFluxo;
    }
}
