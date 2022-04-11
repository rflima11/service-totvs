package br.com.businesstec.servicetotvs.model.entidades;

import javax.persistence.*;

@Entity
@Table(name = "produto_ecommerce")
public class ProdutoEcommerce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_produto")
    private Long idProduto;
    @Column(name = "promocao_loja")
    private String promocaoLoja;
    @Column(name = "esgotado")
    private boolean esgotado;
    @Column(name = "ativo")
    private boolean ativo;
    @Column(name = "cobra_frete")
    private boolean cobraFrete;
    @Column(name = "dias_prazo_entrega")
    private Integer diasPrazoEntrega;
    @Column(name = "imagem_principal")
    private String imagemPrincipal;
    @Column(name = "imagem_alternativa")
    private String imagemAlternativa;

    public ProdutoEcommerce() {}

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

    public Integer getDiasPrazoEntrega() {
        return diasPrazoEntrega;
    }

    public void setDiasPrazoEntrega(Integer diasPrazoEntrega) {
        this.diasPrazoEntrega = diasPrazoEntrega;
    }

    public String getImagemPrincipal() {
        return imagemPrincipal;
    }

    public void setImagemPrincipal(String imagemPrincipal) {
        this.imagemPrincipal = imagemPrincipal;
    }

    public String getImagemAlternativa() {
        return imagemAlternativa;
    }

    public void setImagemAlternativa(String imagemAlternativa) {
        this.imagemAlternativa = imagemAlternativa;
    }
}
