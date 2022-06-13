package br.com.alura.srtch.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length=10)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String cpf;

  @Column(nullable = false)
  private String telefone;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String profissao;

  @Column(nullable = false, length = 10)
  private BigDecimal renda;

  @OneToOne(cascade = CascadeType.ALL)
  private Endereco endereco;

  @Enumerated(EnumType.STRING)
  private StatusCliente status;

  public Cliente(String nome, String cpf, String telefone, String email, String profissao, BigDecimal renda, Endereco endereco, StatusCliente status) {
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.email = email;
    this.profissao = profissao;
    this.renda = renda;
    this.endereco = endereco;
    this.status = status;
  }

  public Cliente() {}

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getProfissao() {
    return profissao;
  }

  public void setProfissao(String profissao) {
    this.profissao = profissao;
  }

  public BigDecimal getRenda() {
    return renda;
  }

  public void setRenda(BigDecimal renda) {
    this.renda = renda;
  }

  public StatusCliente getStatus() {
    return status;
  }

  public void setStatus(StatusCliente status) {
    this.status = status;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  @Override
  public String toString() {
    return "Cliente{" +
        "nome='" + nome + '\'' +
        ", cpf='" + cpf + '\'' +
        ", telefone='" + telefone + '\'' +
        ", email='" + email + '\'' +
        ", rua='" + endereco.getRua() + '\'' +
        ", numero='" + endereco.getNumero() + '\'' +
        ", complemento='" + endereco.getComplemento() + '\'' +
        ", bairro='" + endereco.getBairro() + '\'' +
        ", cidade='" + endereco.getCidade() + '\'' +
        ", estado='" + endereco.getEstado() + '\'' +
        ", profissao='" + profissao + '\'' +
        ", renda=" + renda +
        ", status=" + status +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void atualizarStatus(){
    if(this.status.equals(StatusCliente.SUSPENSO)){
      setStatus(StatusCliente.ATIVO);
    }else {
      setStatus(StatusCliente.SUSPENSO);
    }
  }
}
