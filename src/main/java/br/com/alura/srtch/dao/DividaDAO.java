package br.com.alura.srtch.dao;

import br.com.alura.srtch.modelo.Cobranca;
import br.com.alura.srtch.modelo.Divida;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class DividaDAO {

    private EntityManager em;

    public DividaDAO(EntityManager em) {
        this.em = em;
    }

    public  void cadastrar(Divida divida){
        this.em.persist(divida);
    }

    public List<Divida> buscarTodos() {
        String jpql = "SELECT c FROM Divida c";
        return em.createQuery(jpql, Divida.class).getResultList();
    }

    public Divida buscarPorId(Long id) {
        return em.find(Divida.class, id);
    }

    public void atualizar(Divida divida) {
        this.em.merge(divida);
    }

    public void remover(Divida divida) {
        divida = em.merge(divida);
        this.em.remove(divida);
    }

    public List<Divida> buscarDividasSemCobranca() {
        String jpql = "SELECT d FROM Divida d WHERE d.cobranca IS EMPTY";
        return em.createQuery(jpql, Divida.class)
                .getResultList();
    }

    public BigDecimal somarDividasCliente(String cpf){
        String jpql = "SELECT SUM(d.valor) FROM Divida d "
                + "WHERE d.status = 'ABERTA'"
                + "AND d.cliente.cpf = :cpf";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
    }

}
