package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.Marca;
import br.com.businesstec.model.repository.MarcaRepository;
import br.com.businesstec.servicetotvs.service.MarcaService;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaServiceImpl(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public Marca salvar(Long idEntidade, String identificadorOrigem, String descricao) {
        var optionalMarca = marcaRepository.findByIdentificadorOrigem(identificadorOrigem);
        var marca = new Marca(idEntidade, identificadorOrigem, descricao);
        if (optionalMarca.isPresent()) {
            var marcaSalva = optionalMarca.get();
            marca.setId(marcaSalva.getId());
        }
        return marcaRepository.save(marca);
    }

    @Override
    public boolean isMarcaSalva(Long id) {
        return marcaRepository.findById(id).isPresent();
    }
}
