package br.com.alura.srtch.repository;

import br.com.alura.srtch.model.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CobrancasRepository extends JpaRepository<Cobranca, Long> {
}
