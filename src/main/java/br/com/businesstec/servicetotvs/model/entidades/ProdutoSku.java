package br.com.businesstec.servicetotvs.model.entidades;

import javax.persistence.*;

@Entity
@Table(name = "produto_sku")
public class ProdutoSku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_entidade")
    private Long idProduto;
    @Column(name = "identificador_origem")
    private String promocaoLoja;
    @Column(name = "codigo")
    private boolean esgotado;
    @Column(name = "padrao")
    private boolean ativo;
    @Column(name = "estoque")
    private boolean cobraFrete;
    @Column(name = "preco")
    private int diasPrazoEntrega;
    @Column(name = "codigo_gtin")
    private String imagemPrincipal;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "altura")
    private Double altura;
    @Column(name = "largura")
    private Double largura;
    @Column(name = "comprimento")
    private Double comprimento;
    @Column(name = "diametro")
    private Double diametro;

    public ProdutoSku() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getPromocaoLoja() {
        return promocaoLoja;
    }

    public void setPromocaoLoja(String promocaoLoja) {
        this.promocaoLoja = promocaoLoja;
    }

    public boolean isEsgotado() {
        return esgotado;
    }

    public void setEsgotado(boolean esgotado) {
        this.esgotado = esgotado;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isCobraFrete() {
        return cobraFrete;
    }

    public void setCobraFrete(boolean cobraFrete) {
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
}
