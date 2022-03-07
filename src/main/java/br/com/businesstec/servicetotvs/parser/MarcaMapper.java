package br.com.businesstec.servicetotvs.parser;

import br.com.businesstec.servicetotvs.dto.MarcaDTO;
import br.com.businesstec.servicetotvs.model.entidades.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MarcaMapper {

    MarcaMapper INSTANCE = Mappers.getMapper(MarcaMapper.class);

    @Mapping(source = "name", target = "nome")
    @Mapping(source = "featured", target = "emDestaque")
    @Mapping(source = "externalId", target = "idMarca")
    @Mapping(source = "active", target = "ativo")
    Marca map(MarcaDTO dto);

}
