package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.model.entities.Cliente;
import br.com.businesstec.model.entities.Endereco;
import br.com.businesstec.servicetotvs.dto.ParametrosClienteComplementares;
import br.com.businesstec.servicetotvs.dto.SaveRecordParametrosDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SaveRecordParametrosParser {

    SaveRecordParametrosParser INSTANCE = Mappers.getMapper(SaveRecordParametrosParser.class);

    @Mapping(source = "cliente.nomeFantasia", target = "parametros.nomeFantasia")
    @Mapping(source = "cliente.nome", target = "parametros.nome")
    @Mapping(source = "cliente.email", target = "parametros.email")
    @Mapping(source = "cliente.telefone1", target = "parametros.telefone")
//    @Mapping(source = "naoSei", target = "parametros.pagRec")
    @Mapping(source = "endereco.logradouro", target = "parametros.rua")
    @Mapping(source = "endereco.numero", target = "parametros.numero")
    @Mapping(source = "endereco.complemento", target = "parametros.complemento")
    @Mapping(source = "endereco.bairro", target = "parametros.bairro")
    @Mapping(source = "endereco.cidade", target = "parametros.cidade")
//    @Mapping(source = "naoSei", target = "parametros.codet")
    @Mapping(source = "endereco.cep", target = "parametros.cep")
    @Mapping(source = "endereco.logradouro", target = "parametros.ruaPgto")
    @Mapping(source = "endereco.numero", target = "parametros.numeroPgto")
    @Mapping(source = "endereco.bairro", target = "parametros.bairroPgto")
    @Mapping(source = "endereco.cidade", target = "parametros.cidadePgto")
    @Mapping(source = "endereco.estado", target = "parametros.codetPgto")
    @Mapping(source = "endereco.cep", target = "parametros.cepEntrega")
    @Mapping(source = "endereco.logradouro", target = "parametros.ruaEntrega")
    @Mapping(source = "endereco.numero", target = "parametros.numeroEntrega")
    @Mapping(source = "endereco.bairro", target = "parametros.bairroEntrega")
    @Mapping(source = "endereco.cidade", target = "parametros.cidadeEntrega")
//    @Mapping(source = "naoSei", target = "parametros.codetEntrega")
    @Mapping(source = "cliente.telefone1", target = "parametros.celular")
    @Mapping(source = "endereco.estado", target = "parametros.estado")
    @Mapping(source = "endereco.cep", target = "parametros.cepPagamento")
    @Mapping(source = "cliente.cpfCnpj", target = "parametros.cpfCnpj")

//    @Mapping(source = "naoSei", target = "parametros.codigoMunicipio")
//    @Mapping(source = "naoSei", target = "parametros.codigoMunicipioPagamento")
//    @Mapping(source = "naoSei", target = "parametros.codigoMunicipioEntrega")
    SaveRecordParametrosDTO map(Cliente cliente, Endereco endereco);

    @AfterMapping
    default void afterMap(Cliente cliente, @MappingTarget SaveRecordParametrosDTO saveRecordParametrosDTO) {
        var parametros= saveRecordParametrosDTO.getParametros();
        if (cliente.getCpfCnpj().length() > 11) {
            parametros.setPessoaFisicaOuJuridica("J");
            parametros.setInscricaoEstadual(cliente.getRgIe());
        } else {
            parametros.setPessoaFisicaOuJuridica("F");
            parametros.setRg(cliente.getRgIe());
        }

        if (Objects.isNull(saveRecordParametrosDTO.getParametros().getEmail())) {
            parametros.setEmail("email-nao-informado@email.com");
        }

        if (Objects.isNull(saveRecordParametrosDTO.getParametros().getNomeFantasia())) {
            parametros.setNomeFantasia(parametros.getNome());
        }

        saveRecordParametrosDTO.setParametrosComplementares(new ParametrosClienteComplementares());

    }
}
