package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ProdutoSkuEcommerce;
import br.com.businesstec.model.repository.ProdutoSkuEcommerceRepository;
import br.com.businesstec.servicetotvs.service.ProdutoSkuEcommerceService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoSkuEcommerceServiceImpl implements ProdutoSkuEcommerceService {

    private final ProdutoSkuEcommerceRepository produtoSkuEcommerceRepository;

    public ProdutoSkuEcommerceServiceImpl(ProdutoSkuEcommerceRepository produtoSkuEcommerceRepository) {
        this.produtoSkuEcommerceRepository = produtoSkuEcommerceRepository;
    }

    @Override
    public ProdutoSkuEcommerce salvar(ProdutoSkuEcommerce produtoSkuEcommerce) {
        var produtoSkuEcommerceOptional = produtoSkuEcommerceRepository.findByIdProdutoSku(produtoSkuEcommerce.getIdProdutoSku());

        if (produtoSkuEcommerceOptional.isPresent()) {
            var produtoSalvo = produtoSkuEcommerceOptional.get();
            produtoSkuEcommerce.setId(produtoSalvo.getId());

        }
        return produtoSkuEcommerceRepository.save(produtoSkuEcommerce);
    }
}
