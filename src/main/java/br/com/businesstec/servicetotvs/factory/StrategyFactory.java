package br.com.businesstec.servicetotvs.factory;

import br.com.businesstec.servicetotvs.enums.NomeStrategy;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class StrategyFactory {

    private Map<NomeStrategy, EntidadeStrategy> strategies;

    @Autowired
    public StrategyFactory(Set<EntidadeStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public EntidadeStrategy findStrategy(NomeStrategy strategyName) {
        return strategies.get(strategyName);
    }
    private void createStrategy(Set<EntidadeStrategy> strategySet) {
        strategies = new HashMap<NomeStrategy, EntidadeStrategy>();
        strategySet.forEach(
                strategy ->strategies.put(strategy.getNomeStrategy(), strategy));
    }
}
