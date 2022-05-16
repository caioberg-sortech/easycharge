package br.com.alura.srtch.projections;


import java.math.BigDecimal;

public interface ClienteRelatorioProjection {
    String getNome();
    BigDecimal getTotalDividas();
    Integer getCobrancas();
}
