package br.com.alura.srtch.dto;



import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private Long id;

    @NotBlank(message = "O campo Nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O campo CPF não pode estar vazio")
    private String cpf;

    @NotBlank(message = "O campo Telefone não pode estar vazio")
    private String telefone;

    @NotBlank(message = "O campo email não pode estar vazio")
    private String email;

    @NotBlank(message = "O campo rua não pode estar vazio")
    private String rua;

    @NotBlank(message = "O campo número não pode estar vazio")
    private String numero;

    private String complemento;

    @NotBlank(message = "O campo bairro não pode estar vazio")
    private String bairro;

    @NotBlank(message = "O campo cidade não pode estar vazio")
    private String cidade;

    @NotBlank(message = "O campo estado não pode estar vazio")
    private String estado;

    @NotBlank(message = "O campo profissão não pode estar vazio")
    private String profissao;

    @NotNull
    @Positive(message = "A renda não pode ser zero")
    private BigDecimal renda;

    @NotNull
    private StatusCliente status;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.rua = cliente.getEndereco().getRua();
        this.numero = cliente.getEndereco().getNumero();
        this.complemento = cliente.getEndereco().getComplemento();
        this.bairro = cliente.getEndereco().getBairro();
        this.cidade = cliente.getEndereco().getCidade();
        this.estado = cliente.getEndereco().getEstado();
        this.profissao = cliente.getProfissao();
        this.renda = cliente.getRenda();
        this.status = cliente.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getProfissao() {
        return profissao;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }

    public static List<ClienteDTO> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}