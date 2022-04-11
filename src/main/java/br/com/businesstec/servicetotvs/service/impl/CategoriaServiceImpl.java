package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.model.entidades.Categoria;
import br.com.businesstec.servicetotvs.repository.CategoriaRepository;
import br.com.businesstec.servicetotvs.service.CategoriaService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        var categoriaOpcional = categoriaRepository.findByIdentificadorOrigem(categoria.getIdentificadorOrigem());
        if (categoriaOpcional.isPresent()) {
            var categoriaSalva = categoriaOpcional.get();
            categoria.setId(categoriaSalva.getId());
        }
        return categoriaRepository.save(categoria);
    }
}
