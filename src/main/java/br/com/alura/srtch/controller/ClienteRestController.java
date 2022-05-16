package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteApiDTO;
import br.com.alura.srtch.dto.ClienteDetalhamentoDTO;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.projection.ClienteRelatorioProjection;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public Page<ClienteApiDTO> lista(@PageableDefault(size = 5, page = 0, sort = {"nome", "status"}, direction = Sort.Direction.ASC) Pageable paginacao){
        Page<Cliente> clientes = clienteRepository.findAll(paginacao);
        return  ClienteApiDTO.converter(clientes);
    }

    @PostMapping
    @CacheEvict(value = "relatorioCliente", allEntries = true)
    @Transactional
    public ResponseEntity<ClienteApiDTO> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = new ClienteMapper().cadastrar(form);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteApiDTO(cliente));
    }

    @GetMapping("/report")
    @Cacheable(value = "relatorioCliente")
   public List<ClienteRelatorioProjection> relatorio(){
        return clienteRepository.findTotalDividasCobrancasPorNome();
    }

    @GetMapping("/{id}")
    public ClienteDetalhamentoDTO detalhamentoCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.getById(id);
        return new ClienteDetalhamentoDTO(cliente);
    }

}
