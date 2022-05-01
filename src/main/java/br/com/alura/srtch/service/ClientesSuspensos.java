package br.com.alura.srtch.service;

import br.com.alura.srtch.StatusCliente;
import br.com.alura.srtch.modelo.Cliente;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ClientesSuspensos {

    private BigDecimal somaRendaClientesSuspensos = BigDecimal.ZERO;


    public int nClientesSuspensos(List<Cliente> clientes){
        int numeroClientesSuspensos = 0;
        for (Cliente cliente : clientes) {
            if (StatusCliente.SUSPENSO.equals(cliente.getStatus())) {
                numeroClientesSuspensos++;
                somaRendaClientesSuspensos = somaRendaClientesSuspensos.add(cliente.getRenda());
            }
        }
        return numeroClientesSuspensos;
    }

    public BigDecimal mediaRendaClientesSuspensos(List<Cliente> clientes){

        int nClientesSuspensos = nClientesSuspensos(clientes);
        BigDecimal mediaRendaClientesSuspensos = somaRendaClientesSuspensos.divide(BigDecimal.valueOf(nClientesSuspensos), 2, RoundingMode.HALF_UP);

        return mediaRendaClientesSuspensos;
    }
}
