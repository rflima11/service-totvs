package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.Marca;
import br.com.businesstec.model.entities.MarcaEcommerce;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MarcaMapper {

    MarcaMapper INSTANCE = Mappers.getMapper(MarcaMapper.class);

    @Mapping(source = "featured", target = "emDestaque")
    @Mapping(source = "active", target = "ativo")
    MarcaEcommerce map(ObjetoTOTVS dto);

    @Mapping(source = "name", target = "descricao")
    @Mapping(source = "externalId", target = "identificadorOrigem")
    Marca mapEntity(ObjetoTOTVS dto);

}
