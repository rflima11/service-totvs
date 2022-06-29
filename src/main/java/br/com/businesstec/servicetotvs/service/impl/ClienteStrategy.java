package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.model.entities.Cliente;
import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;
import br.com.businesstec.model.entities.Endereco;
import br.com.businesstec.servicetotvs.dto.SaveRecordParametrosDTO;
import br.com.businesstec.servicetotvs.enums.EntidadeEnum;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;
import br.com.businesstec.servicetotvs.factory.ConsultaSimpleFactory;
import br.com.businesstec.servicetotvs.mapper.SaveRecordParametrosParser;
import br.com.businesstec.servicetotvs.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClienteStrategy implements JetStrategy {

    private static final Logger logger = LoggerFactory.getLogger(ClienteStrategy.class);


    private final ClienteService clienteService;
    private final EnderecoService enderecoService;
    private final SaveRecordService saveRecordService;
    private final ConsultaSqlService consultaSqlService;
    private final SaveRecordParametrosParser saveRecordParametrosParser;
    private final ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService;
    private final ControleExecucaoFluxoEntidadeEntregaService execucaoFluxoEntidadeEntregaService;


    public ClienteStrategy(ClienteService clienteService, EnderecoService enderecoService, SaveRecordService saveRecordService, ConsultaSqlService consultaSqlService, ControleExecucaoFluxoEntidadeService controleExecucaoFluxoEntidadeService, ControleExecucaoFluxoEntidadeEntregaService execucaoFluxoEntidadeEntregaService) {
        this.clienteService = clienteService;
        this.enderecoService = enderecoService;
        this.saveRecordService = saveRecordService;
        this.consultaSqlService = consultaSqlService;
        this.controleExecucaoFluxoEntidadeService = controleExecucaoFluxoEntidadeService;
        this.execucaoFluxoEntidadeEntregaService = execucaoFluxoEntidadeEntregaService;
        saveRecordParametrosParser = SaveRecordParametrosParser.INSTANCE;
    }

    @Override
    public void executar(ControleExecucaoFluxoEntidade controleExecucaoFluxoEntidade) {

        var cliente = clienteService.encontrarClientePeloIdEntidade(controleExecucaoFluxoEntidade.getIdEntidade());
        var enderecoCliente = enderecoService.encontrarPeloIdCliente(cliente.getId());
        var saveRecordParametros = saveRecordParametrosParser.map(cliente, enderecoCliente);
        inserirCodigoCliente(cliente, saveRecordParametros);
        inserirCodigoCidade(enderecoCliente, saveRecordParametros);
        var result = saveRecordService.salvarRegistro(saveRecordParametros);
        controleExecucaoFluxoEntidadeService.atualizarIntegracao(controleExecucaoFluxoEntidade);
        execucaoFluxoEntidadeEntregaService.registrarExecucao(controleExecucaoFluxoEntidade);
        logger.info(String.format("CLIENTE %s SALVO COM SUCESSO", cliente.getNome()));
    }

    private void inserirCodigoCliente(Cliente cliente, SaveRecordParametrosDTO parametrosDto) {
        var parametros = ConsultaSimpleFactory.getParametrosConsulta(LocalDateTime.now(), EntidadeEnum.CLIENTE.getValue());
        parametros.adicionarParametro(EnumParametersSoap.CNPJ_CPF, cliente.getCpfCnpj());
        var resultado = consultaSqlService.realizaConsulta(parametros);
        var codigoCliente = resultado.getResultados().get(0).getCodigoCliente();
        parametrosDto.getParametros().setCodigoCliente(codigoCliente);
        parametrosDto.getParametrosComplementares().setCodCfo(codigoCliente);
    }

    private void inserirCodigoCidade(Endereco endereco, SaveRecordParametrosDTO parametrosDTO) {
        var parametros = ConsultaSimpleFactory.getParametrosConsulta(LocalDateTime.now(), EntidadeEnum.COD_MUNICIPIO.getValue());
        parametros.adicionarParametro(EnumParametersSoap.UF_MUNICIPIO, endereco.getEstado());
        parametros.adicionarParametro(EnumParametersSoap.MUNCIPIO_S, endereco.getCidade());
        var resultado = consultaSqlService.realizaConsulta(parametros);
        var codigoMunicipio = resultado.getResultados().get(0).getCodMunicipio();
        parametrosDTO.getParametros().setCodigoMunicipio(codigoMunicipio);
    }

    @Override
    public EnumNomeStrategy getNomeStrategy() {
        return EnumNomeStrategy.CLIENTE_STRATEGY;
    }
}
