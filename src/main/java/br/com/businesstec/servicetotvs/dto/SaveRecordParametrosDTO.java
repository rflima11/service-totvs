package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FinCFOBR")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaveRecordParametrosDTO extends SaveRecordRequest{

    @XmlElement(name = "FCFO")
    private ParametrosCliente parametros;

    @XmlElement(name = "FCFOCOMPL")
    private ParametrosClienteComplementares parametrosComplementares;

    public ParametrosCliente getParametros() {
        return parametros;
    }
    public void setParametros(ParametrosCliente parametrosCliente) {
        this.parametros = parametrosCliente;
    }
    public ParametrosClienteComplementares getParametrosComplementares() {
        return parametrosComplementares;
    }
    public void setParametrosComplementares(ParametrosClienteComplementares parametrosComplementares) {
        this.parametrosComplementares = parametrosComplementares;
    }

    @Override
    public String getDataServerName() {
        return "FinCFODataBR";
    }
}
