package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import br.com.businesstec.servicetotvs.model.entidades.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(source = "idProduto", target = "identificadorOrigem")
    Produto map(ObjetoTOTVS dto);

    default boolean map(int value) {
        if (value == 1)
            return true;
        return false;
    };
}
