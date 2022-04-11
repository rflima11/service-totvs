package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.model.entidades.CategoriaEcommerce;
import br.com.businesstec.servicetotvs.repository.CategoriaEcommerceRepository;
import br.com.businesstec.servicetotvs.service.CategoriaEcommerceService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaEcommerceServiceImpl implements CategoriaEcommerceService {

    private final CategoriaEcommerceRepository categoriaEcommerceRepository;

    public CategoriaEcommerceServiceImpl(CategoriaEcommerceRepository categoriaEcommerceRepository) {
        this.categoriaEcommerceRepository = categoriaEcommerceRepository;
    }

    @Override
    public CategoriaEcommerce salvar(CategoriaEcommerce categoriaEcommerce) {
        var categoriaOptional = categoriaEcommerceRepository.findByIdCategoria(categoriaEcommerce.getIdCategoria());
        if (categoriaOptional.isPresent()) {
           var categoriaSalva =  categoriaOptional.get();
            categoriaEcommerce.setId(categoriaSalva.getId());
        }
        return categoriaEcommerceRepository.save(categoriaEcommerce);
    }
}
