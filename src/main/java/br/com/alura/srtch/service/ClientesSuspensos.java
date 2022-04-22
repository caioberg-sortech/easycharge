package br.com.alura.srtch.service;

import br.com.alura.srtch.StatusCliente;
import br.com.alura.srtch.modelo.Cliente;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ClientesSuspensos {

    public void rendaClientesSuspensos(List<Cliente> clientes){
        BigDecimal somaRendaClientesSuspensos = BigDecimal.ZERO;
        int numeroClientesSuspensos = 0;
        for (Cliente cliente : clientes) {
            if (StatusCliente.SUSPENSO.equals(cliente.getStatus())) {
                numeroClientesSuspensos++;
                somaRendaClientesSuspensos = somaRendaClientesSuspensos.add(cliente.getRenda());
            }
        }
        BigDecimal mediaRendaClientesSuspensos = somaRendaClientesSuspensos.divide(BigDecimal.valueOf(numeroClientesSuspensos), 2, RoundingMode.HALF_UP);

        System.out.printf("\nHá %s clientes suspensos.\n", numeroClientesSuspensos);
        System.out.printf("A média de renda dos clientes suspensos é de R$ %.2f\n\n", mediaRendaClientesSuspensos);

    }
}
