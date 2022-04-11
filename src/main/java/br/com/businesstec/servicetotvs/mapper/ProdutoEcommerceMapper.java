package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import br.com.businesstec.servicetotvs.model.entidades.Produto;
import br.com.businesstec.servicetotvs.model.entidades.ProdutoEcommerce;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProdutoEcommerceMapper {

    ProdutoEcommerceMapper INSTANCE = Mappers.getMapper(ProdutoEcommerceMapper.class);

    ProdutoEcommerce map(ObjetoTOTVS dto);

    default boolean map(String value) {
        if (Integer.valueOf(value) == 1)
            return true;
        return false;
    };
}
