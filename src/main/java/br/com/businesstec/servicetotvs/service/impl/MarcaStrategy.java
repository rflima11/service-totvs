package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.NomeStrategy;
import br.com.businesstec.servicetotvs.parser.MarcaMapper;
import br.com.businesstec.servicetotvs.repository.MarcaRepository;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MarcaStrategy implements EntidadeStrategy {

    private static final Logger logger = LoggerFactory.getLogger(MarcaStrategy.class);


    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;

    public MarcaStrategy(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
        this.marcaMapper = MarcaMapper.INSTANCE;
    }

    @Override
    public void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO) {
        var marcas = realizarConsultaSQLResponseDTO.getResultados();
        var marcasModel = marcas.stream().map(marcaMapper::map).collect(Collectors.toList());

        logger.info("=======================================================================");
        logger.info("REALIZANDO INSERÇÃO DE " + marcas.size() + " MARCAS NO BANCO DE DADOS");
        logger.info("=======================================================================");

        marcaRepository.saveAll(marcasModel);
    }

    @Override
    public NomeStrategy getNomeStrategy() {
        return NomeStrategy.MARCA_STRATEGY;
    }
}
