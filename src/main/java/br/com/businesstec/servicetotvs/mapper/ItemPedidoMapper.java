package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.ItemPedidoEcommerce;
import br.com.businesstec.servicetotvs.dto.InformacoesPedido;
import br.com.businesstec.servicetotvs.dto.OrdersItemDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemPedidoMapper {

    ItemPedidoMapper INSTANCE = Mappers.getMapper(ItemPedidoMapper.class);

    @Mapping(source = "identificadorOrigemProduto", target = "idProduto")
    OrdersItemDto map(ItemPedidoEcommerce itemPedido);

    @AfterMapping
    default void afterMap(@MappingTarget OrdersItemDto ordersItemDto) {
        ordersItemDto.setPrecoUnitario(ordersItemDto.getPrecoUnitario().replace(".", ","));
        ordersItemDto.setQuantidade(ordersItemDto.getQuantidade().replace(".", ","));
    }
}
