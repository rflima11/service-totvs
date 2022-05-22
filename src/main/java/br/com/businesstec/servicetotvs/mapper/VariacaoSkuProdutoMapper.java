package br.com.businesstec.servicetotvs.mapper;


import br.com.businesstec.model.entities.VariacaoProdutoSku;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VariacaoSkuProdutoMapper {

    VariacaoSkuProdutoMapper INSTANCE = Mappers.getMapper(VariacaoSkuProdutoMapper.class);

    @Mapping(source = "idProdutoSku", target = "idProdutoSku")
    @Mapping(source = "idVariacaoItem", target = "idVariacaoItem")
    VariacaoProdutoSku map(ObjetoTOTVS dto);
}
