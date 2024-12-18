package br.com.businesstec.servicetotvs.enums;

public enum EnumTipoEntidade {

    PRODUTO(1L),
    MARCA(2L),
    CATEGORIA(3L),
    VARIACAO(4L),
    PRODUTO_SKU(5L),
    PRODUTO_IMAGEM(8L),
    PRODUTO_ESTOQUE(7L),
    PRODUTO_PRECO(6L),
    PRODUTO_SKU_VARIACO(6L);


    private Long value;

    EnumTipoEntidade(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
