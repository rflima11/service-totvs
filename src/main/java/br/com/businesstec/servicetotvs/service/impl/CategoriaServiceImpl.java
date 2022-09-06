package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.Categoria;
import br.com.businesstec.model.repository.CategoriaRepository;
import br.com.businesstec.servicetotvs.enums.EnumTipoEntidade;
import br.com.businesstec.servicetotvs.mapper.CategoriaEcommerceMapper;
import br.com.businesstec.servicetotvs.service.CategoriaService;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.service.EntidadeService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ConsultaSqlService consultaSqlService;
    private final CategoriaEcommerceMapper categoriaMapper;
    private final EntidadeService entidadeService;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, ConsultaSqlService consultaSqlService, EntidadeService entidadeService) {
        this.categoriaRepository = categoriaRepository;
        this.consultaSqlService = consultaSqlService;
        this.entidadeService = entidadeService;
        this.categoriaMapper = CategoriaEcommerceMapper.INSTANCE;
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        categoria.setIdEntidade(entidadeService.salvar(EnumTipoEntidade.CATEGORIA).getId());
        return categoriaRepository.save(categoria);
    }
}
