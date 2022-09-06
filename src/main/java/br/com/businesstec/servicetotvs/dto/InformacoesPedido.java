package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
public class InformacoesPedido {

    @XmlElement(name = "CODCOLIGADA")
    private Long codColigada = 1L;

    @XmlElement(name = "TIPO")
    private String tipo = "P";

    @XmlElement(name = "CODTMV")
    private String codTmv = "2.1.06";

    @XmlElement(name = "NUMEROMOV")
    private int numeroMov = -1;

    @XmlElement(name = "IDMOV")
    private String idMov = "";

    @XmlElement(name = "STATUS")
    private String status = "F";

    @XmlElement(name = "CODCOLCFO")
    private int codColCfo = 1;

    @XmlElement(name = "CODCFO")
    private String codigoCliente;

    @XmlElement(name = "CAMPOLIVRE1")
    private String campoLivre;

    @XmlElement(name = "DATAEMISSAO")
    private LocalDateTime dataEmissao;

    @XmlElement(name = "VALORFRETE")
    private String valorFrete;

    public InformacoesPedido() {}

    public Long getCodColigada() {
        return codColigada;
    }

    public void setCodColigada(Long codColigada) {
        this.codColigada = codColigada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodTmv() {
        return codTmv;
    }

    public void setCodTmv(String codTmv) {
        this.codTmv = codTmv;
    }

    public int getNumeroMov() {
        return numeroMov;
    }

    public void setNumeroMov(int numeroMov) {
        this.numeroMov = numeroMov;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCodColCfo() {
        return codColCfo;
    }

    public void setCodColCfo(int codColCfo) {
        this.codColCfo = codColCfo;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCampoLivre() {
        return campoLivre;
    }

    public void setCampoLivre(String campoLivre) {
        this.campoLivre = campoLivre;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getIdMov() {
        return idMov;
    }

    public void setIdMov(String idMov) {
        this.idMov = idMov;
    }

    public String getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(String valorFrete) {
        this.valorFrete = valorFrete;
    }
}
