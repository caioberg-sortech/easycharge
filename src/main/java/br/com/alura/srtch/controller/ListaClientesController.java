package br.com.alura.srtch.controller;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

public class ListaClientesController {

    @Autowired
    private ClienteRepository clienteRepository;


    public String clientes(Model model){

        List<Cliente> clientes = clienteRepository.findAll();

        return  "clientes";

    }


}
