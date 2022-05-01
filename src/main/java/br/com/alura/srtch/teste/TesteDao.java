package br.com.alura.srtch.teste;

import br.com.alura.srtch.StatusCliente;
import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.EnderecoDao;
import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.Endereco;
import br.com.alura.srtch.util.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TesteDao {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        Endereco endereco = new Endereco("0","203","Apartamento","Cruzeiro Novo"
                , "Brasilia","DF");
        Cliente cliente = new Cliente("Caio Berg", "06654939166", "61995532410"
                ,"caioberg09@gmail.com","Programador",new BigDecimal(1000),endereco, StatusCliente.ATIVO);

        ClienteDao clienteDAO = new ClienteDao(em);
        EnderecoDao enderecoDAO = new EnderecoDao(em);

        em.getTransaction().begin();

        enderecoDAO.cadastrar(endereco);
        clienteDAO.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }
}
