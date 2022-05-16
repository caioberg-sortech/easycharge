package br.com.alura.srtch.validacao;

import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;

import java.math.BigDecimal;

public class DividaValidacao {

    public boolean validacaoValorDivida(ClienteRepository clienteRepository, DividaRepository dividaRepository, Long clienteId, BigDecimal valorAdd){
        BigDecimal valorT = dividaRepository.findTotalDividaCliente(clienteId);
        BigDecimal renda = clienteRepository.getById(clienteId).getRenda();

        if(valorT.add(valorAdd).doubleValue() > new BigDecimal(12).multiply(renda).doubleValue()){
            return true;
        }
        return false;
    }
}
