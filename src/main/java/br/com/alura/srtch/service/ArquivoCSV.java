package br.com.alura.srtch.service;

import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.util.JPAUtil;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import javax.persistence.EntityManager;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoCSV {

    public List<Cliente> lerArquivo(String arquivo){
        List<Cliente> clientes;

        try {
            Reader reader = new FileReader(arquivo);

            CsvToBean<Cliente> csvToBean = new CsvToBeanBuilder<Cliente>(reader)
                    .withType(Cliente.class)
                    .build();
            clientes = csvToBean.parse();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }

        return clientes;
    }

}
