package br.com.alura.srtch.controller;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ListaClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("listaClientes")
    public String listarClientes(Model model){

        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "status").and(Sort.by(Sort.Direction.ASC, "nome")));
        model.addAttribute("clientes", clientes);
        return "listaClientes";

    }

    @GetMapping("/remover/{id}")
    public String remover( @PathVariable Long id){
        clienteRepository.deleteById(id);
        return "redirect:/listaClientes";
    }

    @GetMapping("/alterarStatus/{id}")
    public String alterarStatus( @PathVariable Long id){
        Cliente cliente = clienteRepository.getById(id);
        if(cliente.getStatus().equals(StatusCliente.SUSPENSO)){
            cliente.setStatus(StatusCliente.ATIVO);
        }else{
            cliente.setStatus(StatusCliente.SUSPENSO);
        }
        clienteRepository.save(cliente);
        return "redirect:/listaClientes";
    }


}
