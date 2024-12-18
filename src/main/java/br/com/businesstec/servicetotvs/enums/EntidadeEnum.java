package br.com.businesstec.servicetotvs.enums;

public enum EntidadeEnum {

    PRODUTO(1L),
    MARCA_PRODUTO(2L),
    CATEGORIA(3L),
    VARIACOES(4L),
    CATEGORIA_POR_PRODUTO(9L),
    VARIACOES_ITEM(99L),
    PRODUTO_SKU(5L),
    PRODUTO_SKU_VARIACOES(150L),
    IMAGEM_PRODUTO(8L),
    PRECO_PRODUTO(6L),
    CLIENTE(11L),
    COD_MUNICIPIO(88L),
    ESTOQUE_PRODUTO(7L);


    EntidadeEnum(long value) {
        this.value = value;
    }

    private long value;

    public long getValue() {
        return value;
    }
}
