package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.CategoriaEcommerce;
import br.com.businesstec.model.repository.CategoriaEcommerceRepository;
import br.com.businesstec.servicetotvs.mapper.CategoriaEcommerceMapper;
import br.com.businesstec.servicetotvs.service.CategoriaEcommerceService;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaEcommerceServiceImpl implements CategoriaEcommerceService {

    private final CategoriaEcommerceRepository categoriaEcommerceRepository;
    private final ConsultaSqlService consultaSqlService;
    private final CategoriaEcommerceMapper categoriaEcommerceMapper;

    public CategoriaEcommerceServiceImpl(CategoriaEcommerceRepository categoriaEcommerceRepository, ConsultaSqlService consultaSqlService) {
        this.categoriaEcommerceRepository = categoriaEcommerceRepository;
        this.consultaSqlService = consultaSqlService;
        categoriaEcommerceMapper = CategoriaEcommerceMapper.INSTANCE;
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
