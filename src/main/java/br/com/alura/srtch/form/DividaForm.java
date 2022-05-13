package br.com.alura.srtch.form;


import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.model.StatusDivida;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DividaForm {

    @NotNull
    private Long cliente_id;

    @Positive
    @NotNull
    private BigDecimal valor;

    @PastOrPresent
    @NotNull
    private LocalDate abertura;

    @PastOrPresent
    private LocalDate quitacao;

    @NotNull
    private StatusDivida status = StatusDivida.ABERTA;

    @Length(max = 255)
    private String descricaoDeQuitacao;

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
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
