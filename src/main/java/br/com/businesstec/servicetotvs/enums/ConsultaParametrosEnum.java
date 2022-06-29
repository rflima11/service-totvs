package br.com.businesstec.servicetotvs.enums;

public enum ConsultaParametrosEnum {

    COD_SISTEMA("T"),
    COD_COLIGADA("1"),
    COD_SETENCA_PRODUTO("JET.005"),
    COD_SETENCA_PRODUTO_SKU("JET.006"),
    COD_SETENCA_PRODUTO_SKU_VARIACOES("JET.006.V"),
    COD_SETENCA_MARCAS("JET.001"),
    COD_SETENCA_CATEGORIAS("JET.003"),
    COD_SETENCA_CATEGORIAS_PARA_PRODUTOS("JET.005.C"),
    COD_SENTENCA_VARIACOES("JET.002"),
    COD_SETENCA_IMAGEM("JET.009"),
    COD_SETENCA_PRECO("JET.007"),
    COD_SETENCA_CLIENTE("JET.101"),
    COD_SETENCA_MUNICIPIO("JET.102"),
    COD_SETENCA_ESTOQUE("JET.008"),

    COD_SETENCA_VARIACOES_ITEM("JET.002.L");

    private String value;

    ConsultaParametrosEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
