package br.com.businesstec.servicetotvs.dto;

import br.com.businesstec.servicetotvs.utils.CDATAAdapter;
import com.sun.xml.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class SvRecordTest {

    @XmlJavaTypeAdapter(type = ParametrosCliente.class, value= CDATAAdapter.class)
    @XmlElement(name = "FCFO")
    private String body;

    @XmlCDATA
    public String getBody() {
        return body;
    }
    @XmlCDATA
    public void setBody(String body) {
        this.body = body;
    }
}
