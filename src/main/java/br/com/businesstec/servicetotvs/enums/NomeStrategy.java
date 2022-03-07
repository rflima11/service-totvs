package br.com.businesstec.servicetotvs.enums;

import java.util.Objects;

public enum NomeStrategy {

    PRODUTO_STRATEGY(1L),
    MARCA_STRATEGY(2L),
    CATEGORIA_STRATEGY(3L);

    Long value;

    NomeStrategy(long value) {
        this.value = value;
    }

    NomeStrategy getStrategyById(int id) {
        return null;
    }

    public static NomeStrategy getStrategyByIdEntidade(Long idEntidade) {
        for (NomeStrategy e : values()) {
            if (Objects.equals(e.value, idEntidade)) {
                return e;
            }
        }
        return null;
    }
}
