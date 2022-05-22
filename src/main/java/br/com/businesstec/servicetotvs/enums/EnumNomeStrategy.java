package br.com.businesstec.servicetotvs.enums;

import java.util.Objects;

public enum EnumNomeStrategy {

    PRODUTO_STRATEGY(1L),
    MARCA_STRATEGY(2L),
    CATEGORIA_STRATEGY(3L),
    VARIACAO_STRATEGY(4L),
    LISTA_VARIACAO_STRATEGY(6L),
    SKU_STRATEGY(5L);

    Long value;

    EnumNomeStrategy(long value) {
        this.value = value;
    }

    EnumNomeStrategy getStrategyById(int id) {
        return null;
    }

    public static EnumNomeStrategy getStrategyByIdEntidade(Long idEntidade) {
        for (EnumNomeStrategy e : values()) {
            if (Objects.equals(e.value, idEntidade)) {
                return e;
            }
        }
        return null;
    }
}
