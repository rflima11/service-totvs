package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.ProdutoCategoria;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaProdutoMapper {

    CategoriaProdutoMapper INSTANCE = Mappers.getMapper(CategoriaProdutoMapper.class);

    @Mapping(source = "idProdutoCategoria", target = "idProduto")
    @Mapping(source = "idCategoriaProduto", target = "idCategoria")
    @Mapping(source = "principal", target = "principal")
    ProdutoCategoria map(ObjetoTOTVS dto);

    default boolean map(String value) {
        if (value.toLowerCase().equals("true"))
            return true;
        return false;
    };

}
