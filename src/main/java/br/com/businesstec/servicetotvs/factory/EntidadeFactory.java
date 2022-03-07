package br.com.businesstec.servicetotvs.factory;

import br.com.businesstec.servicetotvs.dto.EntidadeEnum;
import br.com.businesstec.servicetotvs.dto.MarcaDTO;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.model.entidades.Marca;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.util.Objects;

public class EntidadeFactory {

    public void getEntidadeResponse(String xmlAsString, Long idEntidade) {
            try {
                if (Objects.equals(EntidadeEnum.MARCA_PRODUTO.getValue(), idEntidade)) {
                    var jaxbContext = JAXBContext.newInstance(RealizarConsultaSQLResponseDTO.class, MarcaDTO.class);
                    var unmarshaller = jaxbContext.createUnmarshaller();
                    RealizarConsultaSQLResponseDTO marcaResponse = (RealizarConsultaSQLResponseDTO) unmarshaller.unmarshal(new StringReader(xmlAsString));
                    System.out.println(marcaResponse.getResultados());
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }


    }

    public static void main(String[] args) {
        String xml = "<NewDataSet>\n" +
                "  <Resultado>\n" +
                "    <NAME>RAMACRISNA</NAME>\n" +
                "    <FEATURED>FALSE</FEATURED>\n" +
                "    <EXTERNALID>1</EXTERNALID>\n" +
                "    <ACTIVE>TRUE</ACTIVE>\n" +
                "  </Resultado>\n" +
                "  <Resultado>\n" +
                "    <NAME>TERCEIRO TESTE</NAME>\n" +
                "    <FEATURED>FALSE</FEATURED>\n" +
                "    <EXTERNALID>2</EXTERNALID>\n" +
                "    <ACTIVE>TRUE</ACTIVE>\n" +
                "  </Resultado>\n" +
                "</NewDataSet>";

        new EntidadeFactory().getEntidadeResponse(xml,2L);
    }
}
