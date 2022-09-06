package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.Produto;
import br.com.businesstec.model.entities.StatusPedidoEcommerce;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StatusPedidoMapper {

    StatusPedidoMapper INSTANCE = Mappers.getMapper(StatusPedidoMapper.class);

    @Mapping(source = "idOrigem", target = "identificadorOrigemProduto")
    @Mapping(source = "tipoNf", target = "tipoNotaFiscal")
    @Mapping(source = "tipoVolume", target = "tipoVolume")
    @Mapping(source = "serieNf", target = "serieNotaFiscal")
    @Mapping(source = "numNf", target = "numeroNotaFiscal")
    @Mapping(source = "nomeTransp", target = "nomeTransportadora")
    StatusPedidoEcommerce map(ObjetoTOTVS dto);
}
