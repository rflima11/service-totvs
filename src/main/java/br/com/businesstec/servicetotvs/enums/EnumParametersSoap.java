package br.com.businesstec.servicetotvs.enums;

public enum EnumParametersSoap {

    DATASINC_D("DATASINC_D="),
    ID_VARIACAO("IDVARIACAO_I="),
    ID_PRODUTO("IDPRODUTO_I="),
    CNPJ_CPF("CNPJ_CPF_S="),
    UF_MUNICIPIO("UF_S="),
    MUNCIPIO_S("MUNICIPIO_S="),
    ID_PRODUTO_SKU_VARIACAO("IDPRODUTOSKU_I=");

    private String value;

    EnumParametersSoap(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
