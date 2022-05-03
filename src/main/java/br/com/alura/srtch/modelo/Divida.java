package br.com.alura.srtch.modelo;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "divida")
public class Divida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "divida", cascade = CascadeType.ALL)
    private final List<Cobranca> cobranca = new ArrayList<>();

    public Divida(BigDecimal valor, LocalDate abertura, StatusDivida status, Cliente cliente) {
        this.valor = valor;
        this.abertura = abertura;
        this.status = status;
        this.cliente = cliente;
    }

    public Divida() {

    }


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
