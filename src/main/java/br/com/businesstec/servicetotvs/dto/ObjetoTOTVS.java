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
    private Long id;
    @XmlElement(name = "NAME")
    private String name;
    @XmlElement(name = "FEATURED")
    private String featured;
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
    @XmlElement(name = "ULTIMA_ATUALIZACAO")
    private String ultimaAtualizacao;
    @XmlElement(name = "CODIGO")
    private String codigo;
    @XmlElement(name = "PADRAO")
    private int padrao;
    @XmlElement(name = "DESCRICAO")
    private String descricao;
    @XmlElement(name = "DESCRICAO_RESUMIDA")
    private String descricaoResumida;
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
    @XmlElement(name = "NIVEL_SUPERIOR")
    private String nivelSuperior;
    @XmlElement(name = "LINK")
    private String link;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
