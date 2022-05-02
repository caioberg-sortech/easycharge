package br.com.alura.srtch.modelo;


import br.com.alura.srtch.StatusDivida;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "divida")
public class Divida {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate abertura;

    private LocalDate quitacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDivida status = StatusDivida.ABERTA;

    private String descricaoDeQuitacao;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
