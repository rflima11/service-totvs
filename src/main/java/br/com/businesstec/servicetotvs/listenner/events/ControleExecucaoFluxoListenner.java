package br.com.businesstec.servicetotvs.listenner.events;

import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.events.ControleExecucaoFluxoEvent;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.factory.StrategyRmFactory;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Order(1)
public class ControleExecucaoFluxoListenner implements ApplicationListener<ControleExecucaoFluxoEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ControleExecucaoFluxoListenner.class);
    private final ControleExecucaoFluxoService controleExecucaoFluxoService;
    private final ConsultaSqlService consultaSqlService;
    private final StrategyRmFactory strategyFactory;


    public ControleExecucaoFluxoListenner(ControleExecucaoFluxoService controleExecucaoFluxoTentativaService, ConsultaSqlService consultaSqlService, StrategyRmFactory strategyFactory) {
        this.controleExecucaoFluxoService = controleExecucaoFluxoTentativaService;
        this.consultaSqlService = consultaSqlService;
        this.strategyFactory = strategyFactory;
    }

    @Override
    @Retryable(
            value = RuntimeException.class,
            maxAttemptsExpression = "10",
            backoff = @Backoff(delayExpression = "10")
    )
    public void onApplicationEvent(ControleExecucaoFluxoEvent event) {
        var controleExecucaoFluxo = event.getControleExecucaoFluxo();
        var idEntidade = controleExecucaoFluxoService.recuperarTipoEntidade(controleExecucaoFluxo);
        var parametrosDaConsulta = ConsultaSimpleFactory.getParametrosConsulta(idEntidade);
        parametrosDaConsulta.adicionarDataSinc(controleExecucaoFluxo.getDataHora());
        var response = consultaSqlService.realizaConsulta(parametrosDaConsulta);
        if (Objects.isNull(response.getResultados())) {
            logger.info("NÃO FORAM ENCONTRADOS NOVOS REGISTROS ID CONTROLE FLUXO: ".concat(controleExecucaoFluxo.getId().toString()));
        } else {
            var strategy = strategyFactory.findStrategy(EnumNomeStrategy.getStrategyByIdEntidade(idEntidade));
            logger.info("NOVO REGISTRO ENCONTRADO, ESTRATÉGIA: ".concat(strategy.getNomeStrategy().name()));
            strategy.executar(response, controleExecucaoFluxo);
        }
        controleExecucaoFluxoService.atualizarHora(controleExecucaoFluxo);

    }

    @Recover
    private void recover(ControleExecucaoFluxoEvent event) {
        logger.info("Não foi possível realizar a conversão " + event.getControleExecucaoFluxo().getId());
        controleExecucaoFluxoService.atualizarHora(event.getControleExecucaoFluxo());
    }


}
