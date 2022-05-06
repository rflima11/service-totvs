package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.VariacaoItem;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VariacaoItemMapper {

    VariacaoItemMapper INSTANCE = Mappers.getMapper(VariacaoItemMapper.class);

    @Mapping(source = "name", target = "descricao")
    @Mapping(source = "externalId", target = "identificadorOrigem")
    @Mapping(source = "idVariacao", target = "idVariacao")
    VariacaoItem map(ObjetoTOTVS dto);
}
