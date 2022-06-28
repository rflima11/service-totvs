package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.EstoqueProduto;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstoqueProdutoMapper {

    EstoqueProdutoMapper INSTANCE = Mappers.getMapper(EstoqueProdutoMapper.class);

    @Mapping(source = "idProduto", target = "identificadorOrigemProduto")
    @Mapping(source = "idProdutoSku", target = "identificadorOrigemSku")
    EstoqueProduto map(ObjetoTOTVS dto);

}
