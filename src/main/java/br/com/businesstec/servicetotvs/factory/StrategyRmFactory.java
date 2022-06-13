package br.com.businesstec.servicetotvs.factory;

import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class StrategyRmFactory {

    private Map<EnumNomeStrategy, EntidadeStrategy> strategies;

    @Autowired
    public StrategyRmFactory(Set<EntidadeStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public EntidadeStrategy findStrategy(EnumNomeStrategy strategyName) {
        return strategies.get(strategyName);
    }
    private void createStrategy(Set<EntidadeStrategy> strategySet) {
        strategies = new HashMap<EnumNomeStrategy, EntidadeStrategy>();
        strategySet.forEach(
                strategy ->strategies.put(strategy.getNomeStrategy(), strategy));
    }
}
