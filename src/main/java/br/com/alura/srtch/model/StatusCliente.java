package br.com.alura.srtch.model;

public enum StatusCliente {
  ATIVO("ATIVO"), SUSPENSO("SUSPENSO");

  private final String texto;
  StatusCliente(String valor){
    texto = valor;
  }
  public String getTexto() {
    return texto;
  }
}
