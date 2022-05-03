package br.com.alura.srtch.service;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.modelo.Cliente;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoCSV {

    public List<Cliente> lerArquivo(String arquivo){
        List<Cliente> clientes;
        List<ClienteDTO> clientesDTO;

        try {
            Reader reader = new FileReader(arquivo);

            CsvToBean<ClienteDTO> csvToBean = new CsvToBeanBuilder<ClienteDTO>(reader)
                    .withType(ClienteDTO.class)
                    .build();
            clientesDTO = csvToBean.parse();

            clientes = new ClienteMapper().TranformarClienteDTO(clientesDTO);

        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }

        return clientes;
    }

}
