package br.com.alura.srtch.repository;

import br.com.alura.srtch.model.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CobrancasRepository extends JpaRepository<Cobranca, Long> {

    @Query("SELECT COUNT(c.divida) FROM Cobranca c WHERE c.divida = :dividaId")
    Integer findQuantidadeCobrancasEmDivida(Long dividaId);
}
