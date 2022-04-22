package br.com.alura.srtch.teste;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.service.ClientesPorEstado;
import br.com.alura.srtch.service.ClientesSuspensos;
import br.com.alura.srtch.service.LeituraDados;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    List<Cliente> clientes = new LeituraDados().lerArquivo(arquivo);


    System.out.println("# Limites de dívidas dos clientes");
    for (Cliente cliente : clientes) {
      BigDecimal limiteDivida = cliente.getRenda().multiply(BigDecimal.valueOf(12));
      System.out.printf("- o limite máximo de dívida para %s é de R$ %.2f.\n", cliente.getNome(), limiteDivida);
    }

   new ClientesSuspensos().rendaClientesSuspensos(clientes);

    ClientesPorEstado clientesPorEstado = new ClientesPorEstado();
    for (Cliente cliente : clientes) {
      clientesPorEstado.adicionaCliente(cliente);
    }
    System.out.println("# Clientes por estado");
    for (String estado : clientesPorEstado.keySet()) {
      List<Cliente> clientesDoEstado = clientesPorEstado.get(estado);
      System.out.printf("- o estado %s tem %d cliente(s) cadastrado(s).\n", estado, clientesDoEstado.size());
    }


  }

}