package br.com.alura.srtch.mapper;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.model.Endereco;
import br.com.alura.srtch.model.StatusCliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    StatusCliente statusCliente = StatusCliente.ATIVO;

    public List<Cliente> transformarListaClientesDTO(List<ClienteDTO> clientesDTO) {

        List<Cliente> clientes = new ArrayList<>();


        for (ClienteDTO c : clientesDTO) {

            if (c.getStatus().equals("SUSPENSO")) statusCliente = StatusCliente.SUSPENSO;

            Endereco endereco = new Endereco(c.getRua(), c.getNumero(), c.getComplemento(), c.getBairro(),
                    c.getCidade(), c.getEstado());
            clientes.add(new Cliente(c.getNome(), c.getCpf(), c.getTelefone(), c.getEmail(), c.getProfissao(),
                    c.getRenda(), endereco, statusCliente));
        }

        return clientes;
    }

    public Cliente transformarClienteDTO(ClienteDTO clienteDTO) {
        Cliente cliente;

        if (clienteDTO.getStatus().equals("SUSPENSO")) statusCliente = StatusCliente.SUSPENSO;

        Endereco endereco = new Endereco(clienteDTO.getRua(), clienteDTO.getNumero(), clienteDTO.getComplemento(), clienteDTO.getBairro(),
                clienteDTO.getCidade(), clienteDTO.getEstado());
        cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getTelefone(), clienteDTO.getEmail(), clienteDTO.getProfissao(),
                clienteDTO.getRenda(), endereco, statusCliente);


        return cliente;
    }

    public ClienteDTO transformarCliente(Cliente c) {
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setNome(c.getNome());
        clienteDTO.setCpf(c.getCpf());
        clienteDTO.setTelefone(c.getTelefone());
        clienteDTO.setEmail(c.getEmail());
        clienteDTO.setProfissao(c.getProfissao());
        clienteDTO.setRenda(c.getRenda());
        clienteDTO.setRua(c.getEndereco().getRua());
        clienteDTO.setNumero(c.getEndereco().getNumero());
        clienteDTO.setComplemento(c.getEndereco().getComplemento());
        clienteDTO.setBairro(c.getEndereco().getBairro());
        clienteDTO.setCidade(c.getEndereco().getCidade());
        clienteDTO.setEstado(c.getEndereco().getEstado());
        clienteDTO.setStatus(c.getStatus());
        clienteDTO.setId(c.getId());
        return clienteDTO;
    }

    public Cliente atualizarCliente(Cliente cliente, ClienteDTO clienteDTO) {

        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNome(clienteDTO.getNome());
        cliente.setProfissao(clienteDTO.getProfissao());
        cliente.setRenda(clienteDTO.getRenda());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setStatus(clienteDTO.getStatus());
        cliente.setEndereco(new Endereco(clienteDTO.getRua(), clienteDTO.getNumero(), clienteDTO.getComplemento(), clienteDTO.getBairro(), clienteDTO.getCidade(), clienteDTO.getEstado()));
        return cliente;
    }

    public Cliente cadastrar(ClienteForm form) {
        Endereco endereco;
        endereco = new Endereco(form.getRua(), form.getNumero(), form.getComplemento(), form.getBairro(), form.getCidade(), form.getEstado());

        return new Cliente(form.getNome(), form.getCpf(), form.getTelefone(), form.getEmail(), form.getProfissao(), form.getRenda(), endereco, StatusCliente.ATIVO);
    }

}

