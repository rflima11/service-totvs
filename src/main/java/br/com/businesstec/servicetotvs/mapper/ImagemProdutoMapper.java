package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.ImagemProduto;
import br.com.businesstec.servicetotvs.dto.ObjetoTOTVS;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImagemProdutoMapper {

    ImagemProdutoMapper INSTANCE = Mappers.getMapper(ImagemProdutoMapper.class);

    @Mapping(source = "id", target = "identificadorOrigem")
    @Mapping(source = "idProduto", target = "identificadorOrigemProduto")
    @Mapping(source = "nome", target = "nomeImagem")
    ImagemProduto map(ObjetoTOTVS dto);

    @AfterMapping
    default void adicionarImagem(ObjetoTOTVS objeto, @MappingTarget ImagemProduto imagemProduto) {
        if (Objects.isNull(objeto.getImagemAlternativa())) {
            imagemProduto.setImagem(objeto.getImagemPrincipal());
            imagemProduto.setPrincipal(true);
            imagemProduto.setAlternativo(false);
        } else {
            imagemProduto.setImagem(objeto.getImagemAlternativa());
            imagemProduto.setPrincipal(false);
            imagemProduto.setAlternativo(true);
        }
    }

}
