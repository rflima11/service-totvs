package br.com.businesstec.servicetotvs.factory;

import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import br.com.businesstec.servicetotvs.service.JetStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class StrategyJetFactory {

    private Map<EnumNomeStrategy, JetStrategy> strategies;

    @Autowired
    public StrategyJetFactory(Set<JetStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public JetStrategy findStrategy(EnumNomeStrategy strategyName) {
        return strategies.get(strategyName);
    }

    private void createStrategy(Set<JetStrategy> strategySet) {
        strategies = new HashMap<EnumNomeStrategy, JetStrategy>();
        strategySet.forEach(
                strategy ->strategies.put(strategy.getNomeStrategy(), strategy));
    }
}
