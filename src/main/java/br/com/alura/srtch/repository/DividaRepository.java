package br.com.alura.srtch.repository;

import br.com.alura.srtch.model.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface DividaRepository extends JpaRepository<Divida, Long> {


    @Query("SELECT SUM(d.valor) FROM Divida d WHERE d.cliente = :clienteId ")
    BigDecimal findTotalDividaCliente(Long clienteId);

}
