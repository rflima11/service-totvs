package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ImagemProduto;
import br.com.businesstec.model.repository.ImagemProdutoRepository;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import br.com.businesstec.servicetotvs.service.ImagemProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ImagemProdutoServiceImpl implements ImagemProdutoService {

    private final ImagemProdutoRepository imagemProdutoRepository;
    private final EntidadeService entidadeService;

    public ImagemProdutoServiceImpl(ImagemProdutoRepository imagemProdutoRepository, EntidadeService entidadeService) {
        this.imagemProdutoRepository = imagemProdutoRepository;
        this.entidadeService = entidadeService;
    }

    @Override
    public ImagemProduto salvar(ImagemProduto imagemProduto) {
        imagemProduto.setId(entidadeService.salvar(EnumTipoEntidade.PRODUTO_IMAGEM).getId());
        return imagemProdutoRepository.save(imagemProduto);
    }
}
