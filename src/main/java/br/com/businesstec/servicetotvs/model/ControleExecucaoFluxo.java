package br.com.businesstec.servicetotvs.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ctrl_execucao_fluxo")
public class ControleExecucaoFluxo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "id_ctrl_fluxo")
    private Long idControleFluxo;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    private Boolean erro;

    @Column(name = "descricao_erro")
    private String descricaoErro;

    public ControleExecucaoFluxo() {}

    public ControleExecucaoFluxo(Long idControleFluxo) {
        this.idControleFluxo = idControleFluxo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdControleFluxo() {
        return idControleFluxo;
    }

    public void setIdControleFluxo(Long idControleFluxo) {
        this.idControleFluxo = idControleFluxo;
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

    public void atualizarHora() {
        this.dataHora = LocalDateTime.now();
    }
}

