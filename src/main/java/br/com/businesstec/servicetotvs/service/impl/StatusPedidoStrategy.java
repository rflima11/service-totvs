package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.mapper.StatusPedidoMapper;
import br.com.businesstec.servicetotvs.service.ControleExecucaoFluxoEntidadeService;
import br.com.businesstec.servicetotvs.service.EntidadeStrategy;
import br.com.businesstec.servicetotvs.service.StatusPedidoService;
import org.springframework.stereotype.Service;

@Service
public class StatusPedidoStrategy implements EntidadeStrategy {

    private final StatusPedidoService statusPedidoService;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final StatusPedidoMapper mapper;

    public StatusPedidoStrategy(StatusPedidoService statusPedidoService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService) {
        this.statusPedidoService = statusPedidoService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        mapper = StatusPedidoMapper.INSTANCE;
    }

    @Override
    public void executar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo) {
        var statusPedido = realizarConsultaSQLResponseDTO.getResultados();
        
        statusPedido.stream().forEach(o -> {
            var statusPedidoEntity = mapper.map(o);
            var statusSalvo = statusPedidoService.salvar(statusPedidoEntity);
            controleExecucaoFluxoEntidadeService.registrar(controleExecucaoFluxo.getId(), statusSalvo.getIdEntidade());
        });
    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.STATUS_PEDIDO_STRATEGY;
    }
}
