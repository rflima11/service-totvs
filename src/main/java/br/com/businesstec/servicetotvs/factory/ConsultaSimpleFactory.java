package br.com.businesstec.servicetotvs.factory;

import br.com.businesstec.servicetotvs.dto.ConsultaParametrosEnum;
import br.com.businesstec.servicetotvs.dto.EntidadeEnum;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class ConsultaSimpleFactory {

    private ConsultaSimpleFactory() { throw new IllegalStateException("Classe utilitária não deve ser instanciada"); }

    public static RealizarConsultaParametrosDTO getParametrosConsulta(Long idEntidade) {
        if (Objects.equals(EntidadeEnum.MARCA_PRODUTO.getValue(), idEntidade)) {
            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_MARCAS.getValue(), LocalDateTime.of(2022, 1, 1, 0, 0));
        }
    return null;
    }
}
