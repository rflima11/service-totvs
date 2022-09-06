package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ObjetoTOTVS {

    @XmlElement(name = "ID")
    private Long idTotvs;
    @XmlElement(name = "ID_MARCA")
    private Long idMarca;
    @XmlElement(name = "IDMARCA")
    private Long idMarcaProduto;
    @XmlElement(name = "NAME")
    private String name;
    @XmlElement(name = "COD_CLIENTE")
    private String codigoCliente;
    @XmlElement(name = "FEATURED")
    private String featured;

    @XmlElement(name = "ID_ORIGEM")
    private String idOrigem;
    @XmlElement(name = "CODIGO_STATUS")
    private String codigoStatus;
    @XmlElement(name = "DATA_STATUS")
    private String dataStatus;
    @XmlElement(name = "TIPO_NF")
    private String tipoNf;
    @XmlElement(name = "TIPO_VOLUME")
    private String tipoVolume;
    @XmlElement(name = "SERIE_NF")
    private String serieNf;
    @XmlElement(name = "NUM_NF")
    private String numNf;
    @XmlElement(name = "DATA_NF")
    private String dataNf;
    @XmlElement(name = "CHAVE_NF")
    private String chaveNf;
    @XmlElement(name = "NOME_TRANSP")
    private String nomeTransp;
    @XmlElement(name = "METODO_ENVIO")
    private String metodoEnvio;
    @XmlElement(name = "NUMERO_RASTREIO")
    private String numeroRastreio;
    @XmlElement(name = "XML_NF")
    private String xmlNf;


    @XmlElement(name = "EXTERNALID")
    private String externalId;
    @XmlElement(name = "ACTIVE")
    private String active;
    @XmlElement(name = "ORDINATIONOFREFERENCES")
    private String ordinationOfReferences;
    @XmlElement(name = "REFERENCETYPE")
    private String referenceType;
    @XmlElement(name = "ID_VARIACAO")
    private String idVariacao;
    @XmlElement(name = "ID_PRODUTO")
    private Long idProduto;
    @XmlElement(name = "ID_PRODUTO_SKU")
    private Long idProdutoSku;
    @XmlElement(name = "ID_VARIACAO_ITEM")
    private String idVariacaoItem;
    @XmlElement(name = "ULTIMA_ATUALIZACAO")
    private String ultimaAtualizacao;
    @XmlElement(name = "CODIGO")
    private String codigo;
    @XmlElement(name = "PADRAO")
    private int padrao;
    @XmlElement(name = "IDPRD")
    private Long idProdutoCategoria;
    @XmlElement(name = "IDCAT")
    private Long idCategoriaProduto;
    @XmlElement(name = "DESCRICAO")
    private String descricao;
    @XmlElement(name = "COD_MUNICIPIO")
    private String codMunicipio;
    @XmlElement(name = "DESCRICAO_RESUMIDA")
    private String descricaoResumida;
    @XmlElement(name = "DESCRICAO_COMPLETA")
    private String descricaoCompleta;
    @XmlElement(name = "ESTOQUE")
    private Double estoque;
    @XmlElement(name = "PRECO")
    private BigDecimal preco;
    @XmlElement(name = "PRECO_PROMOCIONAL")
    private BigDecimal precoPromocional;
    @XmlElement(name = "PESO")
    private Double peso;
    @XmlElement(name = "ALTURA")
    private Double altura;
    @XmlElement(name = "LARGURA")
    private Double largura;
    @XmlElement(name = "COMPRIMENTO")
    private Double comprimento;
    @XmlElement(name = "DIAMETRO")
    private Double diametro;
    @XmlElement(name = "PROMOCAO_LOJA")
    private String promocaoLoja;
    @XmlElement(name = "ESGOTADO")
    private int esgotado;
    @XmlElement(name = "VISIVEL")
    private int visivel;
    @XmlElement(name = "ATIVO")
    private String ativo;
    @XmlElement(name = "COBRA_FRETE")
    private int cobraFrete;
    @XmlElement(name = "DIAS_PRAZO_ENTREGA")
    private int diasPrazoEntrega;
    @XmlElement(name = "IMAGEM_PRINCIPAL")
    private String imagemPrincipal;
    @XmlElement(name = "PRINCIPAL")
    private String principal;
    @XmlElement(name = "IMAGEM_ALTERNATIVA")
    private String imagemAlternativa;
    @XmlElement(name = "NIVEL_SUPERIOR")
    private String nivelSuperior;
    @XmlElement(name = "LINK")
    private String link;
    @XmlElement(name = "NOME")
    private String nome;
    @XmlElement(name = "DEFAULT")
    private String defaultt;


    public Long getIdTotvs() {
        return idTotvs;
    }

    public void setIdTotvs(Long idTotvs) {
        this.idTotvs = idTotvs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getIdVariacao() {
        return idVariacao;
    }

    public void setIdVariacao(String idVariacao) {
        this.idVariacao = idVariacao;
    }

    public String getOrdinationOfReferences() {
        return ordinationOfReferences;
    }

    public void setOrdinationOfReferences(String ordinationOfReferences) {
        this.ordinationOfReferences = ordinationOfReferences;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoResumida() {
        return descricaoResumida;
    }

    public void setDescricaoResumida(String descricaoResumida) {
        this.descricaoResumida = descricaoResumida;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPrecoPromocional() {
        return precoPromocional;
    }

    public void setPrecoPromocional(BigDecimal precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public Double getPeso() {
        return peso;
    }

    public Long getIdMarcaProduto() {
        return idMarcaProduto;
    }

    public void setIdMarcaProduto(Long idMarcaProduto) {
        this.idMarcaProduto = idMarcaProduto;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getDiametro() {
        return diametro;
    }

    public void setDiametro(Double diametro) {
        this.diametro = diametro;
    }

    public String getPromocaoLoja() {
        return promocaoLoja;
    }

    public void setPromocaoLoja(String promocaoLoja) {
        this.promocaoLoja = promocaoLoja;
    }

    public int getEsgotado() {
        return esgotado;
    }

    public void setEsgotado(int esgotado) {
        this.esgotado = esgotado;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public int getCobraFrete() {
        return cobraFrete;
    }

    public void setCobraFrete(int cobraFrete) {
        this.cobraFrete = cobraFrete;
    }

    public int getDiasPrazoEntrega() {
        return diasPrazoEntrega;
    }

    public void setDiasPrazoEntrega(int diasPrazoEntrega) {
        this.diasPrazoEntrega = diasPrazoEntrega;
    }

    public String getImagemPrincipal() {
        return imagemPrincipal;
    }

    public void setImagemPrincipal(String imagemPrincipal) {
        this.imagemPrincipal = imagemPrincipal;
    }

    public String getNivelSuperior() {
        return nivelSuperior;
    }

    public void setNivelSuperior(String nivelSuperior) {
        this.nivelSuperior = nivelSuperior;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPadrao() {
        return padrao;
    }

    public void setPadrao(int padrao) {
        this.padrao = padrao;
    }

    public int getVisivel() {
        return visivel;
    }

    public void setVisivel(int visivel) {
        this.visivel = visivel;
    }

    public Long getIdProdutoSku() {
        return idProdutoSku;
    }

    public void setIdProdutoSku(Long idProdutoSku) {
        this.idProdutoSku = idProdutoSku;
    }

    public String getIdVariacaoItem() {
        return idVariacaoItem;
    }

    public void setIdVariacaoItem(String idVariacaoItem) {
        this.idVariacaoItem = idVariacaoItem;
    }

    public Long getIdProdutoCategoria() {
        return idProdutoCategoria;
    }

    public void setIdProdutoCategoria(Long idProdutoCategoria) {
        this.idProdutoCategoria = idProdutoCategoria;
    }

    public Long getIdCategoriaProduto() {
        return idCategoriaProduto;
    }

    public void setIdCategoriaProduto(Long idCategoriaProduto) {
        this.idCategoriaProduto = idCategoriaProduto;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemAlternativa() {
        return imagemAlternativa;
    }

    public void setImagemAlternativa(String imagemAlternativa) {
        this.imagemAlternativa = imagemAlternativa;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getDefaultt() {
        return defaultt;
    }

    public void setDefaultt(String defaultt) {
        this.defaultt = defaultt;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(String idOrigem) {
        this.idOrigem = idOrigem;
    }

    public String getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(String codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getTipoNf() {
        return tipoNf;
    }

    public void setTipoNf(String tipoNf) {
        this.tipoNf = tipoNf;
    }

    public String getTipoVolume() {
        return tipoVolume;
    }

    public void setTipoVolume(String tipoVolume) {
        this.tipoVolume = tipoVolume;
    }

    public String getSerieNf() {
        return serieNf;
    }

    public void setSerieNf(String serieNf) {
        this.serieNf = serieNf;
    }

    public String getNumNf() {
        return numNf;
    }

    public void setNumNf(String numNf) {
        this.numNf = numNf;
    }

    public String getDataNf() {
        return dataNf;
    }

    public void setDataNf(String dataNf) {
        this.dataNf = dataNf;
    }

    public String getChaveNf() {
        return chaveNf;
    }

    public void setChaveNf(String chaveNf) {
        this.chaveNf = chaveNf;
    }

    public String getNomeTransp() {
        return nomeTransp;
    }

    public void setNomeTransp(String nomeTransp) {
        this.nomeTransp = nomeTransp;
    }

    public String getMetodoEnvio() {
        return metodoEnvio;
    }

    public void setMetodoEnvio(String metodoEnvio) {
        this.metodoEnvio = metodoEnvio;
    }

    public String getNumeroRastreio() {
        return numeroRastreio;
    }

    public void setNumeroRastreio(String numeroRastreio) {
        this.numeroRastreio = numeroRastreio;
    }

    public String getXmlNf() {
        return xmlNf;
    }

    public void setXmlNf(String xmlNf) {
        this.xmlNf = xmlNf;
    }
}
