package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.model.entidades.MarcaEcommerce;
import br.com.businesstec.servicetotvs.repository.MarcaEcommerceRepository;
import br.com.businesstec.servicetotvs.service.MarcaEcommerceService;
import org.springframework.stereotype.Service;

@Service
public class MarcaEcommerceServiceImpl implements MarcaEcommerceService {

    private final MarcaEcommerceRepository marcaEcommerceRepository;

    public MarcaEcommerceServiceImpl(MarcaEcommerceRepository marcaEcommerceRepository) {
        this.marcaEcommerceRepository = marcaEcommerceRepository;
    }

    @Override
    public MarcaEcommerce salvar(MarcaEcommerce marcaEcommerce) {
        var optionalMarca = marcaEcommerceRepository.findByIdMarca(marcaEcommerce.getIdMarca());
        if (optionalMarca.isPresent()) {
            var marcaSalva = optionalMarca.get();
            marcaEcommerce.setId(marcaSalva.getId());
        }
        return marcaEcommerceRepository.save(marcaEcommerce);
    }
}
