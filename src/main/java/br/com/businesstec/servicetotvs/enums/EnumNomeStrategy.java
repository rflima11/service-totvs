package br.com.businesstec.servicetotvs.enums;

import java.util.Objects;

public enum EnumNomeStrategy {

    PRODUTO_STRATEGY(1L),
    MARCA_STRATEGY(2L),
    CATEGORIA_STRATEGY(3L),
    VARIACAO_STRATEGY(4L),
    SKU_STRATEGY(5L),
    PRECO_PRODUTO(6L),
    ESTOQUE_PRODUTO(7L),
    IMAGEM_PRODUTO(8L),
    CLIENTE_STRATEGY(9L),
    PEDIDO_STRATEGY(10L),
    STATUS_PEDIDO_STRATEGY(11L);

    Long value;

    EnumNomeStrategy(long value) {
        this.value = value;
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
