package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.Entidade;
import br.com.businesstec.model.repository.EntidadeRepository;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import org.springframework.stereotype.Service;

@Service
public class EntidadeServiceImpl implements EntidadeService {

    private final EntidadeRepository entidadeRepository;

    public EntidadeServiceImpl(EntidadeRepository entidadeRepository) {
        this.entidadeRepository = entidadeRepository;
    }

    @Override
    public Entidade salvar(EnumTipoEntidade enumTipoEntidade) {
        return entidadeRepository.save(new Entidade(enumTipoEntidade.getValue()));
    }
}
