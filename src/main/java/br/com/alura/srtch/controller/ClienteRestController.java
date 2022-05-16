package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteApiDTO;
import br.com.alura.srtch.dto.ClienteDetalhamentoDTO;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.projections.ClienteRelatorioProjection;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private final ClienteRepository clienteRepository;

    public ClienteRestController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public Page<ClienteApiDTO> lista(Integer page){
        if( page == null){
            page = 0;
        }
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "status").and(Sort.by(Sort.Direction.ASC,"nome")));

        return clienteRepository.findAll(pageable).map(ClienteApiDTO::new);
    }

    @PostMapping
    public ResponseEntity<ClienteApiDTO> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = new ClienteMapper().cadastrar(form);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteApiDTO(cliente));
    }

    @GetMapping("/relatorio")
   public List<ClienteRelatorioProjection> relatorio(){
        return clienteRepository.findTotalDividasCobrancasPorNome();
    }

    @GetMapping("/{id}")
    public ClienteDetalhamentoDTO detalhamentoCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.getById(id);
        return new ClienteDetalhamentoDTO(cliente);
    }

}
