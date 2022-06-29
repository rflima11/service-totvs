package br.com.businesstec.servicetotvs.dto;

import br.com.businesstec.servicetotvs.utils.CDATAAdapter;
import com.sun.xml.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


//@XmlRootElement(name = "![CDATA[<FinCFOBR ")
@XmlRootElement(name = "FinCFOBR")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaveRecordParametrosDTO {

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
}
