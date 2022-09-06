package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.PedidoEcommerce;
import br.com.businesstec.servicetotvs.dto.InformacoesPedido;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.Objects;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InformacoesPedidoMapper {

    InformacoesPedidoMapper INSTANCE = Mappers.getMapper(InformacoesPedidoMapper.class);

    @Mapping(source = "identificadorOrigem", target = "campoLivre")
    @Mapping(source = "totalFrete", target = "valorFrete")
    InformacoesPedido map(PedidoEcommerce pedidoEcommerce);

    @AfterMapping
    default void afterMap(@MappingTarget InformacoesPedido informacoesPedido) {
        if (Objects.isNull(informacoesPedido.getDataEmissao())) {
            informacoesPedido.setDataEmissao(LocalDateTime.now());
        }

        if (Objects.nonNull(informacoesPedido.getValorFrete())) {
            informacoesPedido.getValorFrete().replace(".", ",");
        }
    }

}
