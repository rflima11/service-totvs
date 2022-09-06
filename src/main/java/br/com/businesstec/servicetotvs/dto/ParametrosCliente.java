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

    @XmlElement(name = "CODCFO")
    private String codigoCliente;

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

    @XmlElement(name = "COMPLEMENTO")
    private String complemento;

    @XmlElement(name = "CIDADE")
    private String cidade;

    @XmlElement(name = "CODETD")
    private String estado;

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

    @XmlElement(name = "CIDENTIDADE")
    private String rg;

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
    private String codigoMunicipio = "22306";

    @XmlElement(name = "CODMUNICIPIOPGTO")
    private String codigoMunicipioPagamento = "22306";

    @XmlElement(name = "CODMUNICIPIOENTREGA")
    private String codigoMunicipioEntrega;

    @XmlElement(name = "PESSOAFISOUJUR")
    private String pessoaFisicaOuJuridica;

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

    @XmlElement(name = "INSCRESTADUAL")
    private String inscricaoEstadual;

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

    @XmlElement(name = "CEPPGTO")
    private String cepPagamento;



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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPagRec() {
        return pagRec;
    }

    public void setPagRec(String pagRec) {
        this.pagRec = pagRec;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRuaPgto() {
        return ruaPgto;
    }

    public void setRuaPgto(String ruaPgto) {
        this.ruaPgto = ruaPgto;
    }

    public String getNumeroPgto() {
        return numeroPgto;
    }

    public void setNumeroPgto(String numeroPgto) {
        this.numeroPgto = numeroPgto;
    }

    public String getBairroPgto() {
        return bairroPgto;
    }

    public void setBairroPgto(String bairroPgto) {
        this.bairroPgto = bairroPgto;
    }

    public String getCidadePgto() {
        return cidadePgto;
    }

    public void setCidadePgto(String cidadePgto) {
        this.cidadePgto = cidadePgto;
    }

    public String getCodetPgto() {
        return codetPgto;
    }

    public void setCodetPgto(String codetPgto) {
        this.codetPgto = codetPgto;
    }

    public String getCepEntrega() {
        return cepEntrega;
    }

    public void setCepEntrega(String cepEntrega) {
        this.cepEntrega = cepEntrega;
    }

    public String getRuaEntrega() {
        return ruaEntrega;
    }

    public void setRuaEntrega(String ruaEntrega) {
        this.ruaEntrega = ruaEntrega;
    }

    public String getNumeroEntrega() {
        return numeroEntrega;
    }

    public void setNumeroEntrega(String numeroEntrega) {
        this.numeroEntrega = numeroEntrega;
    }

    public String getBairroEntrega() {
        return bairroEntrega;
    }

    public void setBairroEntrega(String bairroEntrega) {
        this.bairroEntrega = bairroEntrega;
    }

    public String getCidadeEntrega() {
        return cidadeEntrega;
    }

    public void setCidadeEntrega(String cidadeEntrega) {
        this.cidadeEntrega = cidadeEntrega;
    }

    public String getCodetEntrega() {
        return codetEntrega;
    }

    public void setCodetEntrega(String codetEntrega) {
        this.codetEntrega = codetEntrega;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getCodigoMunicipioPagamento() {
        return codigoMunicipioPagamento;
    }

    public void setCodigoMunicipioPagamento(String codigoMunicipioPagamento) {
        this.codigoMunicipioPagamento = codigoMunicipioPagamento;
    }

    public String getCodigoMunicipioEntrega() {
        return codigoMunicipioEntrega;
    }

    public void setCodigoMunicipioEntrega(String codigoMunicipioEntrega) {
        this.codigoMunicipioEntrega = codigoMunicipioEntrega;
    }

    public String getPessoaFisicaOuJuridica() {
        return pessoaFisicaOuJuridica;
    }

    public void setPessoaFisicaOuJuridica(String pessoaFisicaOuJuridica) {
        this.pessoaFisicaOuJuridica = pessoaFisicaOuJuridica;
    }

    public String getTipoClienteFornecedor() {
        return tipoClienteFornecedor;
    }

    public void setTipoClienteFornecedor(String tipoClienteFornecedor) {
        this.tipoClienteFornecedor = tipoClienteFornecedor;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(String limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getColigadaTipoCliFor() {
        return coligadaTipoCliFor;
    }

    public void setColigadaTipoCliFor(String coligadaTipoCliFor) {
        this.coligadaTipoCliFor = coligadaTipoCliFor;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(String contribuinte) {
        this.contribuinte = contribuinte;
    }

    public String getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(String valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getTpTomador() {
        return tpTomador;
    }

    public void setTpTomador(String tpTomador) {
        this.tpTomador = tpTomador;
    }

    public String getContribuintes() {
        return contribuintes;
    }

    public void setContribuintes(String contribuintes) {
        this.contribuintes = contribuintes;
    }

    public String getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(String numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }

    public String getOrgaoPublico() {
        return orgaoPublico;
    }

    public void setOrgaoPublico(String orgaoPublico) {
        this.orgaoPublico = orgaoPublico;
    }

    public String getCategoriaAutonomo() {
        return categoriaAutonomo;
    }

    public void setCategoriaAutonomo(String categoriaAutonomo) {
        this.categoriaAutonomo = categoriaAutonomo;
    }

    public String getValorOutrasDeducoes() {
        return valorOutrasDeducoes;
    }

    public void setValorOutrasDeducoes(String valorOutrasDeducoes) {
        this.valorOutrasDeducoes = valorOutrasDeducoes;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public String getOptantePeloSimples() {
        return optantePeloSimples;
    }

    public void setOptantePeloSimples(String optantePeloSimples) {
        this.optantePeloSimples = optantePeloSimples;
    }

    public String getRegimeIss() {
        return regimeIss;
    }

    public void setRegimeIss(String regimeIss) {
        this.regimeIss = regimeIss;
    }

    public String getRetencaoIss() {
        return retencaoIss;
    }

    public void setRetencaoIss(String retencaoIss) {
        this.retencaoIss = retencaoIss;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCalculaVp() {
        return calculaVp;
    }

    public void setCalculaVp(String calculaVp) {
        this.calculaVp = calculaVp;
    }

    public String getTipoRendimento() {
        return tipoRendimento;
    }

    public void setTipoRendimento(String tipoRendimento) {
        this.tipoRendimento = tipoRendimento;
    }

    public String getFormaTributacao() {
        return formaTributacao;
    }

    public void setFormaTributacao(String formaTributacao) {
        this.formaTributacao = formaTributacao;
    }

    public String getSituacaoNif() {
        return situacaoNif;
    }

    public void setSituacaoNif(String situacaoNif) {
        this.situacaoNif = situacaoNif;
    }

    public String getIsTotvsMessage() {
        return isTotvsMessage;
    }

    public void setIsTotvsMessage(String isTotvsMessage) {
        this.isTotvsMessage = isTotvsMessage;
    }

    public String getInovarAuto() {
        return inovarAuto;
    }

    public void setInovarAuto(String inovarAuto) {
        this.inovarAuto = inovarAuto;
    }

    public String getAplicaFormula() {
        return aplicaFormula;
    }

    public void setAplicaFormula(String aplicaFormula) {
        this.aplicaFormula = aplicaFormula;
    }

    public String getEntidadeExecutora() {
        return entidadeExecutora;
    }

    public void setEntidadeExecutora(String entidadeExecutora) {
        this.entidadeExecutora = entidadeExecutora;
    }

    public String getAposentadoOuPensionista() {
        return aposentadoOuPensionista;
    }

    public void setAposentadoOuPensionista(String aposentadoOuPensionista) {
        this.aposentadoOuPensionista = aposentadoOuPensionista;
    }

    public String getSocioCoperado() {
        return socioCoperado;
    }

    public void setSocioCoperado(String socioCoperado) {
        this.socioCoperado = socioCoperado;
    }

    public String getTipoRua() {
        return tipoRua;
    }

    public void setTipoRua(String tipoRua) {
        this.tipoRua = tipoRua;
    }

    public String getTipoRuaPagamento() {
        return tipoRuaPagamento;
    }

    public void setTipoRuaPagamento(String tipoRuaPagamento) {
        this.tipoRuaPagamento = tipoRuaPagamento;
    }

    public String getTipoRuaEntrega() {
        return tipoRuaEntrega;
    }

    public void setTipoRuaEntrega(String tipoRuaEntrega) {
        this.tipoRuaEntrega = tipoRuaEntrega;
    }

    public String getTipoBairro() {
        return tipoBairro;
    }

    public void setTipoBairro(String tipoBairro) {
        this.tipoBairro = tipoBairro;
    }

    public String getTipoBairroPagamento() {
        return tipoBairroPagamento;
    }

    public void setTipoBairroPagamento(String tipoBairroPagamento) {
        this.tipoBairroPagamento = tipoBairroPagamento;
    }

    public String getTipoBairroEntrega() {
        return tipoBairroEntrega;
    }

    public void setTipoBairroEntrega(String tipoBairroEntrega) {
        this.tipoBairroEntrega = tipoBairroEntrega;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getIdPaisPagamento() {
        return idPaisPagamento;
    }

    public void setIdPaisPagamento(String idPaisPagamento) {
        this.idPaisPagamento = idPaisPagamento;
    }

    public String getIdPaisEntrega() {
        return idPaisEntrega;
    }

    public void setIdPaisEntrega(String idPaisEntrega) {
        this.idPaisEntrega = idPaisEntrega;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCepPagamento() {
        return cepPagamento;
    }

    public void setCepPagamento(String cepPagamento) {
        this.cepPagamento = cepPagamento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
