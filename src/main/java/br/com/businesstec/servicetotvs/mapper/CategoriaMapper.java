package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import br.com.businesstec.servicetotvs.model.entidades.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    @Mapping(source = "id", target = "identificadorOrigem")
    Categoria map(ObjetoTOTVS dto);

}
