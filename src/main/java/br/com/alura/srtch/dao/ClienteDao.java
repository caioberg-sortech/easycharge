package br.com.alura.srtch.dao;

import br.com.alura.srtch.modelo.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {

    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public  void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }
}
