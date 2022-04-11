package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "NewDataSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class RealizarConsultaSQLResponseDTO {

    @XmlElement(name = "Resultado")
    private List<ObjetoTOTVS> resultados;

    public List<ObjetoTOTVS> getResultados() {
        return resultados;
    }

    public void setResultados(List<ObjetoTOTVS> resultados) {
        this.resultados = resultados;
    }
}
