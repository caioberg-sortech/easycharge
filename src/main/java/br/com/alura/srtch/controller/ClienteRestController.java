package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteApiDTO;
import br.com.alura.srtch.dto.ClienteRelatorio;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteApiDTO> lista(){
        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome").and(Sort.by(Sort.Direction.ASC,"status")));
        return ClienteApiDTO.converter(clientes);

    }

    @PostMapping
    public ResponseEntity<ClienteApiDTO> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = new ClienteMapper().cadastrar(form);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteApiDTO(cliente));
    }

    @GetMapping("/report")
    public List<ClienteRelatorio> relatorio(){

    }

}
