package br.com.businesstec.servicetotvs.dto;

public class RealizarConsultaParametrosDTO {

    private String codSetenca;
    private Integer codColigada;
    private String codSistema;

    public RealizarConsultaParametrosDTO(String codSetenca, Integer codColigada, String codSistema) {
        this.codSetenca = codSetenca;
        this.codColigada = codColigada;
        this.codSistema = codSistema;
    }

    public String getCodSetenca() {
        return codSetenca;
    }

    public void setCodSetenca(String codSetenca) {
        this.codSetenca = codSetenca;
    }

    public Integer getCodColigada() {
        return codColigada;
    }

    public void setCodColigada(Integer codColigada) {
        this.codColigada = codColigada;
    }

    public String getCodSistema() {
        return codSistema;
    }

    public void setCodSistema(String codSistema) {
        this.codSistema = codSistema;
    }
}
