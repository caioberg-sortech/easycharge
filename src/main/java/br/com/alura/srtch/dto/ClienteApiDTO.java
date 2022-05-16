package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteApiDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private String local;
    private BigDecimal renda;
    private StatusCliente status;

    public ClienteApiDTO(Cliente cliente){
        this.local= cliente.getEndereco().getCidade() + "/" +  cliente.getEndereco().getEstado()  ;
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.renda = cliente.getRenda();
        this.status = cliente.getStatus();
        this.telefone = cliente.getTelefone();
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

}
