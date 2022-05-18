package br.com.alura.srtch.form;

import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.model.TipoAcordo;
import br.com.alura.srtch.model.TipoAgente;


import java.time.LocalDate;

public class CobrancaForm {


    private LocalDate dataCobranca;


    private String contato;


    private String agente;


    private TipoAgente tipoAgente;


    private String comentario;


    private String acordo;


    private TipoAcordo tipoAcordo;


    private  LocalDate dataPromessa;

    private Integer parcelas;


    private Long dividaId;

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

    public Long getDividaId() {
        return dividaId;
    }

    public void setDividaId(Long dividaId) {
        this.dividaId = dividaId;
    }
}
