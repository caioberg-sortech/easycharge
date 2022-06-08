package br.com.alura.srtch.repository;


import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.projection.ClienteRelatorioProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query(value = "select nome, sum(divida.valor) as totalDividas , contagemCobrancas.contagem as cobrancas\n" +
             " from clientes\n" +
             " left join divida\n" +
             " on clientes.id=divida.cliente_id\n" +
             " left join (\n" +
             " select divida.cliente_id as clienteId, count(cobranca.id)  as contagem\n" +
             " from cobranca\n" +
             " inner join divida\n" +
             " on divida.id = cobranca.divida_id\n" +
             " group by divida.cliente_id\n" +
             " ) as contagemCobrancas\n" +
             " on contagemCobrancas.clienteId = clientes.id\n" +
             " group by clientes.id", nativeQuery = true )
    List<ClienteRelatorioProjection> findTotalDividasCobrancasPorNome();
}
