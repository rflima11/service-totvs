package br.com.businesstec.servicetotvs.listenner.events;

import br.com.businesstec.servicetotvs.enums.NomeStrategy;
import br.com.businesstec.servicetotvs.events.ControleExecucaoFluxoEvent;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.factory.StrategyFactory;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ControleExecucaoFluxoListenner implements ApplicationListener<ControleExecucaoFluxoEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ControleExecucaoFluxoListenner.class);

    private final ConsultaSqlService consultaSqlService;
    private final StrategyFactory strategyFactory;

    public ControleExecucaoFluxoListenner(ConsultaSqlService consultaSqlService, StrategyFactory strategyFactory) {
        this.consultaSqlService = consultaSqlService;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public void onApplicationEvent(ControleExecucaoFluxoEvent event) {
        var controleExecucaoFluxo = event.getControleExecucaoFluxo();
        var parametrosDaConsulta = ConsultaSimpleFactory.getParametrosConsulta(controleExecucaoFluxo.getIdEntidade());
        var response = consultaSqlService.realizaConsulta(parametrosDaConsulta);
        var strategy = strategyFactory.findStrategy(NomeStrategy.getStrategyByIdEntidade(controleExecucaoFluxo.getIdEntidade()));

        logger.info("NOVA SOLICITAÇÃO DE CONSULTA, ESTRATÉGIA: ".concat(strategy.getNomeStrategy().name()));

        strategy.salvar(response);

    }
}
