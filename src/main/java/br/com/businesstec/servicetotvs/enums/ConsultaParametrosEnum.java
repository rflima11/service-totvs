package br.com.businesstec.servicetotvs.enums;

public enum ConsultaParametrosEnum {

    COD_SISTEMA("T"),
    COD_COLIGADA("1"),
    COD_SETENCA_PRODUTO("JET.005"),
    COD_SETENCA_PRODUTO_SKU("JET.006"),
    COD_SETENCA_MARCAS("JET.001"),
    COD_SETENCA_CATEGORIAS("JET.003"),
    COD_SENTENCA_VARIACOES("JET.002"),
    COD_SETENCA_VARIACOES_ITEM("JET.002.L");

    private String value;

    ConsultaParametrosEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
