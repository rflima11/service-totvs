package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.mapper.ImagemProdutoMapper;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoEntidadeService;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import br.com.businesstec.servicetotvs.service.ImagemProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ImagemProdutoStrategy implements EntidadeStrategy {

    private final ImagemProdutoService imagemProdutoService;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final ImagemProdutoMapper mapper;

    public ImagemProdutoStrategy(ImagemProdutoService imagemProdutoService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.imagemProdutoService = imagemProdutoService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        mapper = ImagemProdutoMapper.INSTANCE;
    }

    @Override
    public void executar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var resultados = realizarConsultaSQLResponseDTO.getResultados();

        resultados.stream().forEach(prdImagem -> {
            var produtoImagemModel = mapper.map(prdImagem);
            var prdImagemSalvo = imagemProdutoService.salvar(produtoImagemModel);
            controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), prdImagemSalvo.getId());
        });
    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.IMAGEM_PRODUTO;
    }
}
