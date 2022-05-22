package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlElement;

public class ParametrosClienteComplementares {

    @XmlElement(name = "CODCOLIGADA")
    private Long codColigada = 1L;
    @XmlElement(name = "CODCFO")
    private String codCfo = "C000100";
    @XmlElement(name = "TXADMZ")
    private String txadmz = "0.00";
    @XmlElement(name = "TP_INDIC")
    private String tipoIndicador = "005";

}
