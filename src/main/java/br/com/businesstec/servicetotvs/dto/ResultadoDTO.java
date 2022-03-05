package br.com.businesstec.servicetotvs.dto;

import java.util.List;

public class ResultadoDTO<T> {

    private List<T> t;

    public List<T> getT() {
        return t;
    }

    public void setT(List<T> t) {
        this.t = t;
    }
}
