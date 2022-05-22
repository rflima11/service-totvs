package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ParametrosCliente {

    @XmlElement(name = "CODCOLIGADA")
    private Long codColigada = 1L;

    @XmlElement(name = "NOMEFANTASIA")
    private String nomeFantasia;

    @XmlElement(name = "NOME")
    private String nome;

    @XmlElement(name = "CGCCFO")
    private String cpfCnpj;

    @XmlElement(name = "EMAIL")
    private String email;

    @XmlElement(name = "TELEFONE")
    private String telefone;

    @XmlElement(name = "PAGREC")
    private String pagRec = "1";

    @XmlElement(name = "RUA")
    private String rua;

    @XmlElement(name = "NUMERO")
    private String numero;

    @XmlElement(name = "BAIRRO")
    private String bairro;

    @XmlElement(name = "CIDADE")
    private String cidade;

    @XmlElement(name = "CODETD")
    private String codet;

    @XmlElement(name = "CEP")
    private String cep;

    @XmlElement(name = "RUAPGTO")
    private String ruaPgto;

    @XmlElement(name = "NUMEROPGTO")
    private String numeroPgto;

    @XmlElement(name = "BAIRROPGTO")
    private String bairroPgto;

    @XmlElement(name = "CIDADEPGTO")
    private String cidadePgto;

    @XmlElement(name = "CODETDPGTO")
    private String codetPgto;

    @XmlElement(name = "CEPENTREGA")
    private String cepEntrega;

    @XmlElement(name = "RUAENTREGA")
    private String ruaEntrega;

    @XmlElement(name = "NUMEROENTREGA")
    private String numeroEntrega;

    @XmlElement(name = "BAIRROENTREGA")
    private String bairroEntrega;

    @XmlElement(name = "CIDADEENTREGA")
    private String cidadeEntrega;

    @XmlElement(name = "CODETDENTREGA")
    private String codetEntrega;

    @XmlElement(name = "TELEX")
    private String celular;

    @XmlElement(name = "CODMUNICIPIO")
    private String codigoMunicipio;

    @XmlElement(name = "CODMUNICIPIOPGTO")
    private String codigoMunicipioPagamento;

    @XmlElement(name = "CODMUNICIPIOENTREGA")
    private String codigoMunicipioEntrega;

    @XmlElement(name = "PESSOAFISOUJUR")
    private String pessaFisicaOuJuridica;

    @XmlElement(name = "CODTCF")
    private String tipoClienteFornecedor = "000";

    @XmlElement(name = "ATIVO")
    private String ativo = "1";

    @XmlElement(name = "LIMITECREDITO")
    private String limiteCredito = "0.000";

    @XmlElement(name = "CODCOLTCF")
    private String coligadaTipoCliFor = "1";

    @XmlElement(name = "INSCRMUNICIPAL")
    private String inscricaoMunicipal = "ISENTO";

    @XmlElement(name = "PAIS")
    private String pais = "Brasil";

    @XmlElement(name = "CONTRIBUINTE")
    private String contribuinte = "0";


    @XmlElement(name = "CFOIMOB")
    private String bloqueado = "0";


    @XmlElement(name = "VALFRETE")
    private String valorFrete = "0.0000";

    @XmlElement(name = "TPTOMADOR")
    private String tpTomador = "0";

    @XmlElement(name = "CONTRIBUINTEISS")
    private String contribuintes = "0";

    @XmlElement(name = "NUMDEPENDENTES")
    private String numeroDependentes = "0";

    @XmlElement(name = "ORGAOPUBLICO")
    private String orgaoPublico = "0";

    @XmlElement(name = "CATEGORIAAUTONOMO")
    private String categoriaAutonomo = "0";

    @XmlElement(name = "VROUTRASDEDUCOESIRRF")
    private String valorOutrasDeducoes = "0.0000";

    @XmlElement(name = "RAMOATIV")
    private String ramoAtividade = "0";

    @XmlElement(name = "OPTANTEPELOSIMPLES")
    private String optantePeloSimples = "0";

    @XmlElement(name = "REGIMEISS")
    private String regimeIss = "N";

    @XmlElement(name = "RETENCAOISS")
    private String retencaoIss = "0";

    @XmlElement(name = "PORTE")
    private String porte = "0";

    @XmlElement(name = "NACIONALIDADE")
    private String nacionalidade = "0";

    @XmlElement(name = "CALCULAAVP")
    private String calculaVp = "0";

    @XmlElement(name = "TIPORENDIMENTO")
    private String tipoRendimento = "000";

    @XmlElement(name = "FORMATRIBUTACAO")
    private String formaTributacao = "00";

    @XmlElement(name = "SITUACAONIF")
    private String situacaoNif = "0";

    @XmlElement(name = "ISTOTVSMESSAGE")
    private String isTotvsMessage = "0";

    @XmlElement(name = "INOVAR_AUTO")
    private String inovarAuto = "0";

    @XmlElement(name = "APLICFORMULA")
    private String aplicaFormula = "F";

    @XmlElement(name = "ENTIDADEEXECUTORAPAA")
    private String entidadeExecutora = "0";

    @XmlElement(name = "APOSENTADOOUPENSIONISTA")
    private String aposentadoOuPensionista = "0";

    @XmlElement(name = "SOCIOCOOPERADO")
    private String socioCoperado = "0";

    @XmlElement(name = "TIPORUA")
    private String tipoRua = "1";

    @XmlElement(name = "TIPORUAPGTO")
    private String tipoRuaPagamento = "1";

    @XmlElement(name = "TIPORUAENTREGA")
    private String tipoRuaEntrega = "1";

    @XmlElement(name = "TIPOBAIRRO")
    private String tipoBairro = "1";

    @XmlElement(name = "TIPOBAIRROPGTO")
    private String tipoBairroPagamento = "1";

    @XmlElement(name = "TIPOBAIRROENTREGA")
    private String tipoBairroEntrega = "1";

    @XmlElement(name = "IDPAIS")
    private String idPais = "1";

    @XmlElement(name = "IDPAISPGTO")
    private String idPaisPagamento = "1";

    @XmlElement(name = "IDPAISENTREGA")
    private String idPaisEntrega = "1";


    public Long getCodColigada() {
        return codColigada;
    }

    public void setCodColigada(Long codColigada) {
        this.codColigada = codColigada;
    }
}
