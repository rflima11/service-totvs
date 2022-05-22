package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.ProdutoSku;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoSkuMapper {

    ProdutoSkuMapper INSTANCE = Mappers.getMapper(ProdutoSkuMapper.class);

    @Mapping(source = "idProduto", target = "identificadorOrigemProduto")
    ProdutoSku map(ObjetoTOTVS dto);

    default boolean map(int value) {
        if (value == 1)
            return true;
        return false;
    };
}
