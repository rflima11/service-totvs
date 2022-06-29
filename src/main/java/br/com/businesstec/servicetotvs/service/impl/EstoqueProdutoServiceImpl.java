package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.EstoqueProduto;
import br.com.businesstec.model.repository.EstoqueProdutoRepository;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import br.com.businesstec.servicetotvs.service.EstoqueProdutoService;
import org.springframework.stereotype.Service;

@Service
public class EstoqueProdutoServiceImpl implements EstoqueProdutoService {

    private final EntidadeService entidadeService;
    private final EstoqueProdutoRepository repository;

    public EstoqueProdutoServiceImpl(EntidadeService entidadeService, EstoqueProdutoRepository repository) {
        this.entidadeService = entidadeService;
        this.repository = repository;
    }

    @Override
    public EstoqueProduto salvar(EstoqueProduto estoqueProduto) {
        estoqueProduto.setIdEntidade(entidadeService.salvar(EnumTipoEntidade.PRODUTO_ESTOQUE).getId());
        return repository.save(estoqueProduto);
    }
}
