package br.com.businesstec.servicetotvs.model;

import org.hibernate.type.BigIntegerType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "ctrl_execucao_fluxo_tentativa")
public class ControleExecucaoFluxoTentativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "id_ctrl_execucao_fluxo")
    private Long idExecucaoFluxo;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "erro")
    private Boolean erro;

    @Column(name = "descricao_erro")
    private String descricaoErro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdExecucaoFluxo() {
        return idExecucaoFluxo;
    }

    public void setIdExecucaoFluxo(Long idExecucaoFluxo) {
        this.idExecucaoFluxo = idExecucaoFluxo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Boolean getErro() {
        return erro;
    }

    public void setErro(Boolean erro) {
        this.erro = erro;
    }

    public String getDescricaoErro() {
        return descricaoErro;
    }

    public void setDescricaoErro(String descricaoErro) {
        this.descricaoErro = descricaoErro;
    }
}
