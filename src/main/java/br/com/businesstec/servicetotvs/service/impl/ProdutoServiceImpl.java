package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.Produto;
import br.com.businesstec.model.repository.ProdutoRepository;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import br.com.businesstec.servicetotvs.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final EntidadeService entidadeService;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, EntidadeService entidadeService) {
        this.produtoRepository = produtoRepository;
        this.entidadeService = entidadeService;

    }

    @Override
    public Produto salvar(Produto produto) {
        var produtoOptional = produtoRepository.findByIdentificadorOrigem(produto.getIdentificadorOrigem());

        if (produtoOptional.isPresent()) {
            var produtoSalvo = produtoOptional.get();
            produto.setId(produtoSalvo.getId());
            produto.setIdEntidade(produtoSalvo.getIdEntidade());
        } else {
            var entidade = entidadeService.salvar(EnumTipoEntidade.PRODUTO);
            produto.setIdEntidade(entidade.getId());
        }
        return produtoRepository.save(produto);
    }

    @Override
    public Produto findByIdentificadorOrigem(String identificadorOrigem) {
        return produtoRepository.findByIdentificadorOrigem(identificadorOrigem).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @Override
    public List<String> encontrarTodosIdentificadoresOrigem() {
        return produtoRepository.findAll().stream().map(Produto::getIdentificadorOrigem).collect(Collectors.toList());
    }


}
