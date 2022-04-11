package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.model.entidades.Produto;
import br.com.businesstec.servicetotvs.repository.ProdutoRepository;
import br.com.businesstec.servicetotvs.service.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto salvar(Produto produto) {
        var produtoOptional = produtoRepository.findByIdentificadorOrigem(produto.getIdentificadorOrigem());
        if (produtoOptional.isPresent()) {
            var produtoSalvo = produtoOptional.get();
            produto.setId(produtoSalvo.getId());
        }
        return produtoRepository.save(produto);
    }
}
