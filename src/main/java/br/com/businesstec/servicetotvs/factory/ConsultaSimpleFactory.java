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

    public static RealizarConsultaParametrosDTO getParametrosConsulta(LocalDateTime dataSinc, Long idEntidade) {
        Map<EnumParametersSoap, String> params = new HashMap<>();

        var formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.ofPattern("yyyyMMdd HH:mm:ss").withZone(ZoneId.systemDefault());
        var horaAtual = dataSinc.atZone(ZoneId.systemDefault());
        params.put(EnumParametersSoap.DATASINC_D, formatter.format(horaAtual));
//        params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 6, 12, 8, 30, 0)));


        if (Objects.equals(EntidadeEnum.MARCA_PRODUTO.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_MARCAS.getValue(), params);

        } else if (Objects.equals(EntidadeEnum.VARIACOES.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SENTENCA_VARIACOES.getValue(), params);

        } else if (Objects.equals(EntidadeEnum.VARIACOES_ITEM.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_VARIACOES_ITEM.getValue(), params);//id);

        } else if (Objects.equals(EntidadeEnum.PRODUTO.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_PRODUTO.getValue(), params);
        } else if (Objects.equals(EntidadeEnum.CATEGORIA.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_CATEGORIAS.getValue(), params);
        } else if (Objects.equals(EntidadeEnum.PRODUTO_SKU.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_PRODUTO_SKU.getValue(), params);
        } else if (Objects.equals(EntidadeEnum.CATEGORIA_POR_PRODUTO.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_CATEGORIAS_PARA_PRODUTOS.getValue(), params);
        } else if (Objects.equals(EntidadeEnum.PRODUTO_SKU_VARIACOES.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_PRODUTO_SKU_VARIACOES.getValue(), params);
        } else if (Objects.equals(EntidadeEnum.IMAGEM_PRODUTO.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_IMAGEM.getValue(), params);
        } else if (Objects.equals(EntidadeEnum.PRECO_PRODUTO.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_PRECO.getValue(), params);
        } else if (Objects.equals(EntidadeEnum.ESTOQUE_PRODUTO.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_ESTOQUE.getValue(), params);
        } else if (Objects.equals(EntidadeEnum.CLIENTE.getValue(), idEntidade)) {
//            params.put(EnumParametersSoap.DATASINC_D, formatter.format(LocalDateTime.of(2022, 05, 06, 11, 30, 0)));

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_CLIENTE.getValue(), new HashMap<>());
        } else if (Objects.equals(EntidadeEnum.COD_MUNICIPIO.getValue(), idEntidade)) {

            return new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_MUNICIPIO.getValue(), new HashMap<>());
        }
        return null;
    }
}
