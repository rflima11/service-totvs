package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.MarcaEcommerce;
import br.com.businesstec.model.entities.ProdutoCategoria;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaProdutoMapper {

    CategoriaProdutoMapper INSTANCE = Mappers.getMapper(CategoriaProdutoMapper.class);

    @Mapping(source = "idProdutoCategoria", target = "idProduto")
    @Mapping(source = "idCategoriaProduto", target = "idCategoria")
    ProdutoCategoria map(ObjetoTOTVS dto);


}
