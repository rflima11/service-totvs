package br.com.businesstec.servicetotvs.dto;

public enum EntidadeEnum {

    PRODUTO(1L),
    MARCA_PRODUTO(2L),
    CATEGORIA_PRODUTO(3L);

    EntidadeEnum(long value) {
        this.value = value;
    }

    private long value;

    public long getValue() {
        return value;
    }
}
