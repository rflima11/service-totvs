package br.com.businesstec.servicetotvs.enums;

public enum EnumTipoFluxo {

    BUSCA_ORIGEM(0);

    private Integer tipo;

    EnumTipoFluxo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }
}
