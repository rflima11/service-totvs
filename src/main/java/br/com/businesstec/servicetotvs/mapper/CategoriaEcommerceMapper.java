package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import br.com.businesstec.servicetotvs.model.entidades.CategoriaEcommerce;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaEcommerceMapper {

    CategoriaEcommerceMapper INSTANCE = Mappers.getMapper(CategoriaEcommerceMapper.class);

    CategoriaEcommerce map(ObjetoTOTVS dto);
}
