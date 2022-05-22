package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.Marca;

public interface MarcaService {

    Marca salvar(Marca marca);

    boolean isMarcaSalva(Long id);
}
