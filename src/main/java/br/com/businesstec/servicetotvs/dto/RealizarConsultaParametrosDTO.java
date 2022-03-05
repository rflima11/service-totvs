package br.com.businesstec.servicetotvs.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RealizarConsultaParametrosDTO {

    private  String codSetenca;
    private LocalDateTime dataUltimoSincronismo;
    private final Integer codColigada;
    private final String codSistema;

    public RealizarConsultaParametrosDTO(String codSetenca, LocalDateTime dataUltimoSincronismo) {
        this.codSistema =  ConsultaParametrosEnum.COD_SISTEMA.getValue();
        this.codColigada = Integer.valueOf(ConsultaParametrosEnum.COD_COLIGADA.getValue());
        this.codSetenca = codSetenca;
        this.dataUltimoSincronismo = dataUltimoSincronismo;
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

    public String getCodSistema() {
        return codSistema;
    }

    public LocalDateTime getDataUltimoSincronismo() {
        return dataUltimoSincronismo;
    }

    public void setDataUltimoSincronismo(LocalDateTime dataUltimoSincronismo) {
        this.dataUltimoSincronismo = dataUltimoSincronismo;
    }

    public String getDatasincParameter() {
        var formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return ConsultaParametrosEnum.DATASINC_D.getValue().concat(formatter.format(this.dataUltimoSincronismo));
    }

}
