package br.com.alura.srtch.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cobranca")
public class Cobranca {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "data_cobranca", nullable = false)
    private LocalDate dataCobranca;

    @Column(nullable = false)
    private String contato;

    @Column(nullable = false)
    private String agente;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_agente", nullable = false)
    private TipoAgente tipoAgente;

    @Column(length = 500, nullable = false)
    private String comentario;

    @Column(length = 500, nullable = false)
    private String acordo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_acordo", nullable = false)
    private TipoAcordo tipoAcordo;

    @Column(name = "data_promessa")
    private  LocalDate dataPromessa;

    private Integer parcelas;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Divida divida;

    public Cobranca() {}

    public Cobranca(LocalDate dataCobranca, String contato, String agente, TipoAgente tipoAgente, String comentario, String acordo, TipoAcordo tipoAcordo, LocalDate dataPromessa, Integer parcelas, Divida divida) {
        this.dataCobranca = dataCobranca;
        this.contato = contato;
        this.agente = agente;
        this.tipoAgente = tipoAgente;
        this.comentario = comentario;
        this.acordo = acordo;
        this.tipoAcordo = tipoAcordo;
        this.dataPromessa = dataPromessa;
        this.parcelas = parcelas;
        this.divida = divida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataCobranca() {
        return dataCobranca;
    }

    public void setDataCobranca(LocalDate dataCobranca) {
        this.dataCobranca = dataCobranca;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public TipoAgente getTipoAgente() {
        return tipoAgente;
    }

    public void setTipoAgente(TipoAgente tipoAgente) {
        this.tipoAgente = tipoAgente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAcordo() {
        return acordo;
    }

    public void setAcordo(String acordo) {
        this.acordo = acordo;
    }

    public TipoAcordo getTipoAcordo() {
        return tipoAcordo;
    }

    public void setTipoAcordo(TipoAcordo tipoAcordo) {
        this.tipoAcordo = tipoAcordo;
    }

    public LocalDate getDataPromessa() {
        return dataPromessa;
    }

    public void setDataPromessa(LocalDate dataPromessa) {
        this.dataPromessa = dataPromessa;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }
}
