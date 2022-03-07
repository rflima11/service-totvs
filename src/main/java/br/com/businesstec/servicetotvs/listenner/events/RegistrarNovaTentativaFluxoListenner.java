package br.com.businesstec.servicetotvs.listenner.events;

import br.com.businesstec.servicetotvs.events.ControleExecucaoFluxoEvent;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxoTentativa;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoTentativaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class RegistrarNovaTentativaFluxoListenner implements ApplicationListener<ControleExecucaoFluxoEvent> {

    private static final Logger logger = LoggerFactory.getLogger(RegistrarNovaTentativaFluxoListenner.class);

    private final ControleExecucaoFluxoTentativaService controleExecucaoFluxoTentativaService;

    public RegistrarNovaTentativaFluxoListenner(ControleExecucaoFluxoTentativaService controleExecucaoFluxoTentativaService) {
        this.controleExecucaoFluxoTentativaService = controleExecucaoFluxoTentativaService;
    }

    @Override
    public void onApplicationEvent(ControleExecucaoFluxoEvent event) {
        var controleExecucaoFluxo = event.getControleExecucaoFluxo();
        logger.info("REGISTRANDO NOVA EXECUÇÃO DE FLUXO, ID: " + controleExecucaoFluxo.getId());
        controleExecucaoFluxoTentativaService.registrarNovaTentativa(controleExecucaoFluxo);
    }
}
