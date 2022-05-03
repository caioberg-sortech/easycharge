package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.DividaDAO;
import br.com.alura.srtch.dao.EnderecoDao;
import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.Divida;
import br.com.alura.srtch.modelo.StatusDivida;
import br.com.alura.srtch.service.ArquivoCSV;
import br.com.alura.srtch.service.ArquivoJSON;
import br.com.alura.srtch.util.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TesteDao {

    public static void main(String[] args) {

        if(args.length <= 0) {
            throw new IllegalArgumentException("Forneça um nome de arquivo.");
        }

        String arquivo = args[0];
        List<Cliente> clientes;

        if (arquivo.endsWith(".csv")) {
            clientes = new ArquivoCSV().lerArquivo(arquivo);
        } else if (arquivo.endsWith(".json")) {
            clientes = new ArquivoJSON().lerArquivo(arquivo);
        } else {
            throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
        }

        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDAO = new ClienteDao(em);
        EnderecoDao enderecoDAO = new EnderecoDao(em);
        DividaDAO dividaDAO = new DividaDAO(em);
        em.getTransaction().begin();

        Divida divida1 = new Divida(new BigDecimal(10000.00), LocalDate.now(), StatusDivida.ABERTA,
                clientes.get(0));
        Divida divida2 = new Divida(new BigDecimal(150000.00), LocalDate.of(2020,05,21), StatusDivida.ABERTA,
                clientes.get(0));
        Divida divida3 = new Divida(new BigDecimal(150.00), LocalDate.of(2021,04,21), StatusDivida.ABERTA,
                clientes.get(1));

        clientes.forEach(clienteDAO::cadastrar);

        dividaDAO.cadastrar(divida1);
        dividaDAO.cadastrar(divida2);
        dividaDAO.cadastrar(divida3);

        dividaDAO.cadastrar(divida1);


        em.close();
    }
}
