package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class RealizarConsultaSQLResponseDTO {

    @XmlElement(name = "Resultado")
    private List<ResultadoDTO> resultados;

    public List<ResultadoDTO> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoDTO> resultados) {
        this.resultados = resultados;
    }
}
