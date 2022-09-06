package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrdersItemDto {

    @XmlElement(name = "CODCOLIGADA")
    private Long codColigada = 1L;

    @XmlElement(name = "IDMOV")
    private String idMov = "";

    @XmlElement(name = "IDPRD")
    private Long idProduto;

    @XmlElement(name = "QUANTIDADE")
    private String quantidade;

    @XmlElement(name = "NSEQITMMOV")
    private int sequencia;

    @XmlElement(name = "PRECOUNITARIO")
    private String precoUnitario;

    public OrdersItemDto() {}

    public Long getCodColigada() {
        return codColigada;
    }

    public void setCodColigada(Long codColigada) {
        this.codColigada = codColigada;
    }

    public String getIdMov() {
        return idMov;
    }

    public void setIdMov(String idMov) {
        this.idMov = idMov;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public String getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(String precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
