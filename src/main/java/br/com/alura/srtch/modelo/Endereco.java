package br.com.alura.srtch.modelo;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(required = true,format = "varchar(255)")
    @Column(nullable = false)
    private String rua;

    @CsvBindByName(required = true,format = "varchar(255)")
    @Column(nullable = false)
    private String numero;

    @Column
    private String complemento;

    @CsvBindByName(required = true,format = "varchar(255)")
    @Column(nullable = false)
    private String bairro;

    @CsvBindByName(required = true,format = "varchar(255)")
    @Column(nullable = false)
    private String cidade;

    @CsvBindByName(required = true,format = "varchar(255)")
    @Column(nullable = false)
    private String estado;

    public Endereco(){};

    public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
