package br.com.alura.srtch.modelo;

import br.com.alura.srtch.StatusCliente;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByNames;
import com.opencsv.bean.CsvIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @CsvBindByName(required = true,format = "varchar(255)")
  private String nome;

  @CsvBindByName(required = true, format = "varchar(255)")
  private String cpf;

  @CsvBindByName(required = false, format = "varchar(255)")
  private String telefone;

  @CsvBindByName(required = true,format = "varchar(255)")
  private String email;

  @CsvBindByName(required = true,format = "varchar(255)")
  private String profissao;

  @CsvBindByName(required = true)
  private BigDecimal renda;

  @OneToOne
  private Endereco endereco;

  @CsvBindByName(required = true)
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
}
