package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.model.entidades.ProdutoEcommerce;
import br.com.businesstec.servicetotvs.repository.ProdutoEcommerceRepository;
import br.com.businesstec.servicetotvs.service.ProdutoEcommerceService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoEcommerceServiceImpl implements ProdutoEcommerceService {

    private final ProdutoEcommerceRepository produtoEcommerceRepository;

    public ProdutoEcommerceServiceImpl(ProdutoEcommerceRepository produtoEcommerceRepository) {
        this.produtoEcommerceRepository = produtoEcommerceRepository;
    }

    @Override
    public ProdutoEcommerce salvar(ProdutoEcommerce produtoEcommerce) {
        var produtoOptional = produtoEcommerceRepository.findByIdProduto(produtoEcommerce.getIdProduto());
        if (produtoOptional.isPresent()) {
            var produtoSalvo = produtoOptional.get();
            produtoEcommerce.setId(produtoSalvo.getId());
        }
        return produtoEcommerceRepository.save(produtoEcommerce);
    }
}
