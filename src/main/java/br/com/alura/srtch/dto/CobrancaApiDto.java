package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cobranca;
import br.com.alura.srtch.model.TipoAcordo;
import br.com.alura.srtch.model.TipoAgente;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CobrancaApiDto {

    private LocalDate dataCobranca;
    private String contato;
    private String agente;
    private TipoAgente tipoAgente;
    private String comentario;
    private Long dividaId;

    public CobrancaApiDto() {

    }

    public CobrancaApiDto(Cobranca cobranca) {
        this.dataCobranca = cobranca.getDataCobranca();
        this.contato = cobranca.getContato();
        this.agente = cobranca.getAgente();
        this.tipoAgente = cobranca.getTipoAgente();
        this.comentario = cobranca.getComentario();
        this.dividaId = cobranca.getDivida().getId();
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

    public Long getDividaId() {
        return dividaId;
    }

    public void setDividaId(Long dividaId) {
        this.dividaId = dividaId;
    }
}
