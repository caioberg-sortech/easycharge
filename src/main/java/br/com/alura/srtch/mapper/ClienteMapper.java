package br.com.alura.srtch.mapper;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Endereco;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public List<Cliente> transformarClienteDTO(List<ClienteDTO> clientesDTO){

        List<Cliente> clientes = new ArrayList<>();

        for (ClienteDTO c : clientesDTO) {
            Endereco endereco = new Endereco(c.getRua(),c.getNumero(),c.getComplemento(),c.getBairro(),
                    c.getCidade(),c.getEstado());
            clientes.add(new Cliente(c.getNome(),c.getCpf(),c.getTelefone(),c.getEmail(),c.getProfissao(),
                    c.getRenda(),endereco,c.getStatus()));
        }

        return clientes;
    }
}