package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.PrecoProduto;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrecoProdutoMapper {

    PrecoProdutoMapper INSTANCE = Mappers.getMapper(PrecoProdutoMapper.class);

    PrecoProduto map(ObjetoTOTVS dto);
}
