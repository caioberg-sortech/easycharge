package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.Endereco;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoJSON {

    public List<Cliente> lerArquivo(String arquivo){

        List<Cliente> clientes;
        List<Endereco> enderecos;

        try {
            Reader reader = new FileReader(arquivo);
            Reader reader1 = new FileReader(arquivo);
            ObjectMapper mapper = new ObjectMapper();

            clientes = mapper.readValue(reader, new TypeReference<>() {});
            enderecos = mapper.readValue(reader1, new TypeReference<>() {});

            int i = 0;
            for (Cliente cliente: clientes) {
                cliente.setEndereco(enderecos.get(i));
                i++;
            }
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }

        return clientes;
    }
}
