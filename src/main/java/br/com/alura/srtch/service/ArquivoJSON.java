package br.com.alura.srtch.service;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoJSON {

    public List<Cliente> lerArquivo(String arquivo){

        List<ClienteDTO> clientesDTO;
        List<Cliente> clientes;

        try {
            Reader reader = new FileReader(arquivo);
            ObjectMapper mapper = new ObjectMapper();

            clientesDTO = mapper.readValue(reader, new TypeReference<List<ClienteDTO>>() {});

            clientes = new ClienteMapper().transformarListaClientesDTO(clientesDTO);

        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }

        return clientes;
    }
}