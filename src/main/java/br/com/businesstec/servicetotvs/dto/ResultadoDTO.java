package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ResultadoDTO {

    private ObjetoTOTVS t;

    public ObjetoTOTVS getT() {
        return t;
    }

    public void setT(ObjetoTOTVS t) {
        this.t = t;
    }
}
