package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.ProdutoSku;
import br.com.businesstec.model.entities.ProdutoSkuEcommerce;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoSkuEcommerceMapper {

    ProdutoSkuEcommerceMapper INSTANCE = Mappers.getMapper(ProdutoSkuEcommerceMapper.class);

    @Mapping(source = "idProdutoSku", target = "id")
    ProdutoSkuEcommerce map(ObjetoTOTVS dto);

    default boolean map(int value) {
        if (value == 1)
            return true;
        return false;
    };

    default boolean map(String value) {
        if (value.equals("1"))
            return true;
        return false;
    };
}
