package br.com.businesstec.servicetotvs.model.entidades;

import javax.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_entidade")
    private Long idEntidade;
    @Column(name = "identificador_origem")
    private String identificadorOrigem;
    @Column(name = "descricao")
    private String descricao;

    public Marca() {}

    public Marca(Long idEntidade, String identificadorOrigem, String descricao) {
        this.idEntidade = idEntidade;
        this.identificadorOrigem = identificadorOrigem;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(Long idEntidade) {
        this.idEntidade = idEntidade;
    }

    public String getIdentificadorOrigem() {
        return identificadorOrigem;
    }

    public void setIdentificadorOrigem(String identificadorOrigem) {
        this.identificadorOrigem = identificadorOrigem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
