package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;
import br.com.businesstec.servicetotvs.dto.InformacoesPedido;
import br.com.businesstec.servicetotvs.dto.OrdersItemDto;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.dto.SaveRecordPedidosDTO;
import br.com.businesstec.servicetotvs.enums.ConsultaParametrosEnum;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.mapper.InformacoesPedidoMapper;
import br.com.businesstec.servicetotvs.mapper.ItemPedidoMapper;
import br.com.businesstec.servicetotvs.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoStrategy implements JetStrategy {

    private static final Logger logger = LoggerFactory.getLogger(ClienteStrategy.class);

    private final PedidoService pedidoService;
    private final ConsultaSqlService consultaSqlService;
    private final ItemPedidoService itemPedidoService;
    private final SaveRecordService saveRecordService;
    private final InformacoesPedidoMapper informacoesPedidoMapper;
    private final ItemPedidoMapper itemPedidoMapper;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final ControleExecucaoFluxoEntidadeEntregaService execucaoFluxoEntidadeEntregaService;

    public PedidoStrategy(PedidoService pedidoService, ConsultaSqlService consultaSqlService, ItemPedidoService itemPedidoService, SaveRecordService saveRecordService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService, ControleExecucaoFluxoEntidadeEntregaService execucaoFluxoEntidadeEntregaService) {
        this.pedidoService = pedidoService;
        this.consultaSqlService = consultaSqlService;
        this.itemPedidoService = itemPedidoService;
        this.saveRecordService = saveRecordService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.execucaoFluxoEntidadeEntregaService = execucaoFluxoEntidadeEntregaService;
        informacoesPedidoMapper = InformacoesPedidoMapper.INSTANCE;
        itemPedidoMapper = ItemPedidoMapper.INSTANCE;
    }

    @Override
    public void executar(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade) {
        var pedido = pedidoService.encontrarPedidoPeloIdEntidade(controleExecucaoFluxoEntidade.getIdEntidade());
        var pedidoRequest = informacoesPedidoMapper.map(pedido);
        inserirCodigoCliente(pedido.getCpfCnpj(), pedidoRequest);
        var itensPedido = itemPedidoService.recuperarItensPedido(pedido.getId());
        var itensPedidoRequest = itensPedido.stream().map(it -> itemPedidoMapper.map(it)).collect(Collectors.toList());
        adicionarNumeroSequencia(itensPedidoRequest);
        var request = new SaveRecordPedidosDTO(pedidoRequest, itensPedidoRequest);
        var response = saveRecordService.salvarRegistro(request);
        controleExecucaoFluxoEntidadeService.atualizarIntegracao(controleExecucaoFluxoEntidade);
        execucaoFluxoEntidadeEntregaService.registrarExecucao(controleExecucaoFluxoEntidade);
        logger.info(String.format("RESPONSE RM A TENTATIVA DE PEDIDO %s: %s", pedidoRequest.getCampoLivre(), response));
    }

    private void adicionarNumeroSequencia(List<OrdersItemDto> ordersItens) {
        for(int i = 0; i < ordersItens.size(); i++) {
            ordersItens.get(i).setSequencia(i + 1);
        }
    }

    private void inserirCodigoCliente(String cpfCnpj, InformacoesPedido informacoesPedido) {
        var parametros = new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_CLIENTE.getValue());
        parametros.adicionarParametro(EnumParametersSoap.CNPJ_CPF, cpfCnpj);
        var resultado = consultaSqlService.realizaConsulta(parametros);
        var codigoCliente = resultado.getResultados().get(0).getCodigoCliente();
        informacoesPedido.setCodigoCliente(codigoCliente);
    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.PEDIDO_STRATEGY;
    }
}
