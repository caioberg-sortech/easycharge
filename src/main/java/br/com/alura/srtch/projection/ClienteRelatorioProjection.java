package br.com.alura.srtch.projection;


import java.math.BigDecimal;

public interface ClienteRelatorioProjection {
    String getNome();
    BigDecimal getTotalDividas();
    Integer getCobrancas();
}
