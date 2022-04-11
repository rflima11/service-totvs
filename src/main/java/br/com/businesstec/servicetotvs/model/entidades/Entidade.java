package br.com.businesstec.servicetotvs.model.entidades;

import javax.persistence.*;

@Entity
@Table(name = "entidade")
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_tipo_entidade")
    private Integer idTipoEntidade;

    public Entidade() {}

    public Entidade(Integer idTipoEntidade) {
        this.idTipoEntidade = idTipoEntidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdEntidade() {
        return idTipoEntidade;
    }

    public void setIdEntidade(Integer idTipoEntidade) {
        this.idTipoEntidade = idTipoEntidade;
    }
}
