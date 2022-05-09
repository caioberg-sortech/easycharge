package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientesController {

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

    @Transactional
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

    @GetMapping("clienteFormulario/{id}")
    public String clienteFormulario(@PathVariable Long id,ClienteDTO clienteDTO){

        Cliente cliente = clienteRepository.getById(id);



        return "clienteFormulario";
    }

    @PostMapping("novoCliente")
    public String novoCliente(@Valid ClienteDTO clienteDTO, BindingResult result){

        if (result.hasErrors()){
            return "clienteFormulario";
        }

        Cliente cliente = new ClienteMapper().transformarClienteDTO(clienteDTO);
        clienteRepository.save(cliente);
        return "redirect:/listaClientes";
    }

}
