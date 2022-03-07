package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ResultadoDTO {

    private MarcaDTO t;

    public MarcaDTO getT() {
        return t;
    }

    public void setT(MarcaDTO t) {
        this.t = t;
    }
}
