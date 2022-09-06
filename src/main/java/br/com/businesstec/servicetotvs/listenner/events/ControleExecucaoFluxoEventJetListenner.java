package br.com.businesstec.servicetotvs.listenner.events;

import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.events.ControleExecucaoFluxoEventJet;
import br.com.businesstec.servicetotvs.factory.StrategyJetFactory;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ControleExecucaoFluxoEventJetListenner implements ApplicationListener<ControleExecucaoFluxoEventJet> {

    private static final Logger logger = LoggerFactory.getLogger(ControleExecucaoFluxoEventJetListenner.class);

    private final StrategyJetFactory strategyFactory;
    private final ControleExecucaoFluxoService controleExecucaoFluxoService;

    public ControleExecucaoFluxoEventJetListenner(StrategyJetFactory strategyFactory, ControleExecucaoFluxoService controleExecucaoFluxoService) {
        this.strategyFactory = strategyFactory;
        this.controleExecucaoFluxoService = controleExecucaoFluxoService;
    }

    @Override
    public void onApplicationEvent(ControleExecucaoFluxoEventJet event) {
        var controleExecucaoFluxo = event.getControleExecucaoFluxoEntidade();
        var idEntidade = controleExecucaoFluxoService.recuperarTipoEntidade(controleExecucaoFluxoService.encontrarPeloId(controleExecucaoFluxo.getIdControleExecucaoFluxo()));
        var strategy = strategyFactory.findStrategy(EnumNomeStrategy.getStrategyByIdEntidade(idEntidade));
        logger.info("NOVO REGISTRO ENCONTRADO, ESTRATÉGIA: ".concat(strategy.getNomeStrategy().name()));
        strategy.executar(controleExecucaoFluxo);

    }
}
