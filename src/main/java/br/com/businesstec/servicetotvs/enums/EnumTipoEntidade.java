package br.com.businesstec.servicetotvs.enums;

public enum EnumTipoEntidade {

    PRODUTO(1),
    MARCA(2),
    CATEGORIA(3),
    VARIACAO(4),
    PRODUTO_SKU(5);

    private Integer value;

    EnumTipoEntidade(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
