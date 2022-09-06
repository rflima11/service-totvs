package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "MovMovimento")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaveRecordPedidosDTO extends SaveRecordRequest {

    @XmlElement(name = "TMOV")
    private InformacoesPedido informacoesPedido;

    @XmlElement(name = "TITMMOV")
    private List<OrdersItemDto> itensPedido;

    public SaveRecordPedidosDTO() {}

    public SaveRecordPedidosDTO(InformacoesPedido informacoesPedido, List<OrdersItemDto> itensPedido) {
        this.informacoesPedido = informacoesPedido;
        this.itensPedido = itensPedido;
    }

    public InformacoesPedido getInformacoesPedido() {
        return informacoesPedido;
    }

    public void setInformacoesPedido(InformacoesPedido informacoesPedido) {
        this.informacoesPedido = informacoesPedido;
    }

    public List<OrdersItemDto> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<OrdersItemDto> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String getDataServerName() {
        return "MOVMOVIMENTOTBCDATA";
    }
}
