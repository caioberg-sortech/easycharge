package br.com.alura.srtch.repository;


import br.com.alura.srtch.dto.ClienteRelatorio;
import br.com.alura.srtch.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query(value = "select nome, sum(divida.valor), contagemCobrancas.contagem" +
             "from clientes" +
             "left join divida" +
             "on  clientes.id=divida.cliente_id" +
             " left join (" +
             "select divida.cliente_id as clienteId, count(cobranca.id)  as contagem" +
             " from cobranca" +
             " inner join divida" +
             " on divida.id=cobranca.divida_id" +
             "group by divida.cliente_id" +
             ") as contagemCobrancas" +
             "on contagemCobrancas.clienteId = clientes.id" +
             "group by clientes.id", nativeQuery = true )
    List<ClienteRelatorio> findTotalDividasCobrancasPorNome();
}
