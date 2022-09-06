package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.MarcaEcommerce;
import br.com.businesstec.model.repository.MarcaEcommerceRepository;
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
        return marcaEcommerceRepository.save(marcaEcommerce);
    }
}
