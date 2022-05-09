package br.com.alura.srtch.mapper;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Endereco;
import br.com.alura.srtch.model.StatusCliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    StatusCliente statusCliente = StatusCliente.ATIVO;

    public List<Cliente> transformarListaClientesDTO(List<ClienteDTO> clientesDTO){

        List<Cliente> clientes = new ArrayList<>();


        for (ClienteDTO c : clientesDTO) {

            if (c.getStatus().equals("SUSPENSO")) statusCliente = StatusCliente.SUSPENSO;

            Endereco endereco = new Endereco(c.getRua(),c.getNumero(),c.getComplemento(),c.getBairro(),
                    c.getCidade(),c.getEstado());
            clientes.add(new Cliente(c.getNome(),c.getCpf(),c.getTelefone(),c.getEmail(),c.getProfissao(),
                    c.getRenda(),endereco,statusCliente));
        }

        return clientes;
    }

    public Cliente transformarClienteDTO(ClienteDTO clienteDTO){
        Cliente cliente;

            if (clienteDTO.getStatus().equals("SUSPENSO")) statusCliente = StatusCliente.SUSPENSO;

            Endereco endereco = new Endereco(clienteDTO.getRua(),clienteDTO.getNumero(),clienteDTO.getComplemento(),clienteDTO.getBairro(),
                    clienteDTO.getCidade(),clienteDTO.getEstado());
            cliente = new Cliente(clienteDTO.getNome(),clienteDTO.getCpf(),clienteDTO.getTelefone(),clienteDTO.getEmail(),clienteDTO.getProfissao(),
                    clienteDTO.getRenda(),endereco,statusCliente);


        return cliente;
    }
}
