package br.com.alura.srtch.repository;

import br.com.alura.srtch.model.Divida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividaRepository extends JpaRepository<Divida, Long> {
}
