package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.CategoriaEcommerce;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaEcommerceMapper {

    CategoriaEcommerceMapper INSTANCE = Mappers.getMapper(CategoriaEcommerceMapper.class);

    @Mapping(source = "id", target = "idCategoria")
    CategoriaEcommerce map(ObjetoTOTVS dto);
}
