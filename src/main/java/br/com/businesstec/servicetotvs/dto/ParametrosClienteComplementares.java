package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ParametrosClienteComplementares {

    @XmlElement(name = "CODCOLIGADA")
    private Long codColigada = 1L;
    @XmlElement(name = "CODCFO")
    private String codCfo;
    @XmlElement(name = "TXADMZ")
    private String txadmz = "0.00";
    @XmlElement(name = "TP_INDIC")
    private String tipoIndicador = "005";

    public String getCodCfo() {
        return codCfo;
    }

    public void setCodCfo(String codCfo) {
        this.codCfo = codCfo;
    }
}
