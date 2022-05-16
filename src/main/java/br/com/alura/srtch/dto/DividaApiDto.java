package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.model.StatusDivida;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DividaApiDto {

    private Long cliente_id;
    private BigDecimal valor;
    private LocalDate abertura;
    private LocalDate quitacao;
    private StatusDivida status = StatusDivida.ABERTA;
    private String descricaoDeQuitacao;

    public DividaApiDto(){}

    public DividaApiDto(Divida divida) {
        this.cliente_id = divida.getClienteId();
        this.valor = divida.getValor();
        this.abertura = divida.getAbertura();
        this.quitacao = divida.getQuitacao();
        this.status = divida.getStatus();
        this.descricaoDeQuitacao = divida.getDescricaoDeQuitacao();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalDate abertura) {
        this.abertura = abertura;
    }

    public LocalDate getQuitacao() {
        return quitacao;
    }

    public void setQuitacao(LocalDate quitacao) {
        this.quitacao = quitacao;
    }

    public StatusDivida getStatus() {
        return status;
    }

    public void setStatus(StatusDivida status) {
        this.status = status;
    }

    public String getDescricaoDeQuitacao() {
        return descricaoDeQuitacao;
    }

    public void setDescricaoDeQuitacao(String descricaoDeQuitacao) {
        this.descricaoDeQuitacao = descricaoDeQuitacao;
    }

}
