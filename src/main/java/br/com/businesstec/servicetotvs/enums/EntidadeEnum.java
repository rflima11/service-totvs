package br.com.businesstec.servicetotvs.enums;

public enum EntidadeEnum {

    PRODUTO(1L),
    MARCA_PRODUTO(2L),
    CATEGORIA(3L),
    VARIACOES(4L),
    PRODUTO_SKU(5L),
    PRECO_PRODUTO(6L),
    ESTOQUE_PRODUTO(7L),

    IMAGEM_PRODUTO(8L),
    CLIENTE(9L),
    STATUS_PEDIDO(11L);


    EntidadeEnum(long value) {
        this.value = value;
    }

    private long value;

    public long getValue() {
        return value;
    }
}
