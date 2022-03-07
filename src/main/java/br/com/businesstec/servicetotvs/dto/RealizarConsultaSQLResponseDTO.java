package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "NewDataSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class RealizarConsultaSQLResponseDTO {

    @XmlElement(name = "Resultado")
    private List<MarcaDTO> resultados;

    public List<MarcaDTO> getResultados() {
        return resultados;
    }

    public void setResultados(List<MarcaDTO> resultados) {
        this.resultados = resultados;
    }
}
