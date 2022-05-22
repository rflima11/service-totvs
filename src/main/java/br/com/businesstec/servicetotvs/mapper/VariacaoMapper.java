package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.Variacao;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VariacaoMapper {

    VariacaoMapper INSTANCE = Mappers.getMapper(VariacaoMapper.class);

    @Mapping(source = "name", target = "descricao")
    @Mapping(source = "externalId", target = "identificadorOrigem")
    Variacao map(ObjetoTOTVS dto);

}
