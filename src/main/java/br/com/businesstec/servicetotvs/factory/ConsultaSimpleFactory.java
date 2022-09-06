package br.com.businesstec.servicetotvs.factory;

import br.com.businesstec.servicetotvs.enums.ConsultaParametrosEnum;
import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConsultaSimpleFactory {

    private ConsultaSimpleFactory() {
        throw new IllegalStateException("Classe utilitária não deve ser instanciada");
    }

    public static RealizarConsultaParametrosDTO getParametrosConsulta(Long idEntidade) {
        if (Objects.equals(EntidadeEnum.MARCA_PRODUTO.getValue(), idEntidade)) {
            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_MARCAS.getValue());

        } else if (Objects.equals(EntidadeEnum.VARIACOES.getValue(), idEntidade)) {

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SENTENCA_VARIACOES.getValue());

        } else if (Objects.equals(EntidadeEnum.PRODUTO.getValue(), idEntidade)) {

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_PRODUTO.getValue());
        } else if (Objects.equals(EntidadeEnum.CATEGORIA.getValue(), idEntidade)) {

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_CATEGORIAS.getValue());
        } else if (Objects.equals(EntidadeEnum.PRODUTO_SKU.getValue(), idEntidade)) {

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_PRODUTO_SKU.getValue());
        }  else if (Objects.equals(EntidadeEnum.IMAGEM_PRODUTO.getValue(), idEntidade)) {

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_IMAGEM.getValue());
        } else if (Objects.equals(EntidadeEnum.PRECO_PRODUTO.getValue(), idEntidade)) {

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_PRECO.getValue());
        } else if (Objects.equals(EntidadeEnum.ESTOQUE_PRODUTO.getValue(), idEntidade)) {

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_ESTOQUE.getValue());
        } else if (Objects.equals(EntidadeEnum.STATUS_PEDIDO.getValue(), idEntidade)) {
            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_STATUS_PEDIDO.getValue());
        }

        throw new RuntimeException("Não encontrado o tipo de execução");
    }
}
