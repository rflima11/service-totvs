package br.com.businesstec.servicetotvs.dto;

public enum ConsultaParametrosEnum {

    COD_SISTEMA("T"),
    COD_COLIGADA("1"),
    DATASINC_D("DATASINC_D="),
    COD_SETENCA_MARCAS("JET.001");

    private String value;

    ConsultaParametrosEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
