package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.PrecoProduto;
import br.com.businesstec.model.repository.PrecoProdutoRepository;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import br.com.businesstec.servicetotvs.service.PrecoProdutoService;
import org.springframework.stereotype.Service;

@Service
public class PrecoProdutoServiceImpl implements PrecoProdutoService {

    private final PrecoProdutoRepository precoProdutoRepository;
    private final EntidadeService entidadeService;

    public PrecoProdutoServiceImpl(PrecoProdutoRepository precoProdutoRepository, EntidadeService entidadeService) {
        this.precoProdutoRepository = precoProdutoRepository;
        this.entidadeService = entidadeService;
    }

    @Override
    public PrecoProduto salvar(PrecoProduto precoProduto) {
        precoProduto.setIdEntidade(entidadeService.salvar(EnumTipoEntidade.PRODUTO_PRECO).getIdEntidade());
        return precoProdutoRepository.save(precoProduto);
    }
}
