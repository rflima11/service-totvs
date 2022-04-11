package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import br.com.businesstec.servicetotvs.model.entidades.ProdutoSku;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoSkuMapper {

    ProdutoSkuMapper INSTANCE = Mappers.getMapper(ProdutoSkuMapper.class);

    ProdutoSku map(ObjetoTOTVS dto);

    default boolean map(int value) {
        if (value == 1)
            return true;
        return false;
    };
}
