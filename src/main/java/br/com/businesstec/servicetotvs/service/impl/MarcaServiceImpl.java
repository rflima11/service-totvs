package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.Marca;
import br.com.businesstec.model.repository.MarcaRepository;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import br.com.businesstec.servicetotvs.service.MarcaService;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;
    private final EntidadeService entidadeService;

    public MarcaServiceImpl(MarcaRepository marcaRepository, EntidadeService entidadeService) {
        this.marcaRepository = marcaRepository;
        this.entidadeService = entidadeService;
    }

    @Override
    public Marca salvar(Marca marca) {
        marca.setIdEntidade(entidadeService.salvar(EnumTipoEntidade.MARCA).getId());
        return marcaRepository.save(marca);
    }

    @Override
    public boolean isMarcaSalva(Long id) {
        return marcaRepository.findById(id).isPresent();
    }
}
