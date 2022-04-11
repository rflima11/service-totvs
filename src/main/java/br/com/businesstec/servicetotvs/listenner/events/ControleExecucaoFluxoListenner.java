package br.com.businesstec.servicetotvs.listenner.events;

import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.events.ControleExecucaoFluxoEvent;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.factory.StrategyFactory;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Order(1)
public class ControleExecucaoFluxoListenner implements ApplicationListener<ControleExecucaoFluxoEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ControleExecucaoFluxoListenner.class);

    private final ControleExecucaoFluxoService controleExecucaoFluxoService;
    private final ConsultaSqlService consultaSqlService;
    private final StrategyFactory strategyFactory;


    public ControleExecucaoFluxoListenner(ControleExecucaoFluxoService controleExecucaoFluxoTentativaService, ConsultaSqlService consultaSqlService, StrategyFactory strategyFactory) {
        this.controleExecucaoFluxoService = controleExecucaoFluxoTentativaService;
        this.consultaSqlService = consultaSqlService;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public void onApplicationEvent(ControleExecucaoFluxoEvent event) {
        var controleExecucaoFluxo = event.getControleExecucaoFluxo();
        var idEntidade = controleExecucaoFluxoService.recuperarTipoEntidade(controleExecucaoFluxo);
        var parametrosDaConsulta = ConsultaSimpleFactory.getParametrosConsulta(controleExecucaoFluxo.getDataHora(), idEntidade);
        var response = consultaSqlService.realizaConsulta(parametrosDaConsulta);
        if (Objects.isNull(response.getResultados())) {
            //tratar se nao vier registros
            logger.info("NÃO FORAM ENCONTRADOS NOVOS REGISTROS ID CONTROLE FLUXO: ".concat(controleExecucaoFluxo.getId().toString()));

        } else {
            var strategy = strategyFactory.findStrategy(EnumNomeStrategy.getStrategyByIdEntidade(idEntidade));
            logger.info("NOVO REGISTRO ENCONTRADO, ESTRATÉGIA: ".concat(strategy.getNomeStrategy().name()));
            strategy.salvar(response, controleExecucaoFluxo);
        }

        controleExecucaoFluxoService.atualizarHora(controleExecucaoFluxo);
    }
}
