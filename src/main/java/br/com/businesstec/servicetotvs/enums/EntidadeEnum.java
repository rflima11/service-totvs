package br.com.businesstec.servicetotvs.enums;

public enum EntidadeEnum {

    PRODUTO(1L),
    MARCA_PRODUTO(2L),
    CATEGORIA(3L),
    VARIACOES(4L),
    CATEGORIA_POR_PRODUTO(9L),
    VARIACOES_ITEM(5L),
    PRODUTO_SKU(6L);

    EntidadeEnum(long value) {
        this.value = value;
    }

    private long value;

    public long getValue() {
        return value;
    }
}
