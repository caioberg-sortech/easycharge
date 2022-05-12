package br.com.alura.srtch.controller;

import br.com.alura.srtch.form.ClienteRelatorioForm;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/clientes")
public class ClienteRestController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteRelatorioForm> lista(){
        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome").and(Sort.by(Sort.Direction.ASC,"status")));
        return ClienteRelatorioForm.converter(clientes);

    }
}
