package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("clientes")
public class NovoClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/novoCliente")
    public String novoCliente(ClienteDTO clienteDTO){
        return "clientes/novoCliente";
    }
    

}
