package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteApiDTO;
import br.com.alura.srtch.dto.ClienteDetalhamentoDTO;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;
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
@CrossOrigin
public class ClienteRestController {

    private final ClienteRepository clienteRepository;

    public ClienteRestController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/api/clientes")
    public Page<ClienteApiDTO> lista(@PageableDefault(size = 5, page = 0, sort = {"status", "nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        Page<Cliente> clientes = clienteRepository.findAll(paginacao);
        return  ClienteApiDTO.converter(clientes);

    }

    @PostMapping("/api/clientes")
    @CacheEvict(value = "relatorioCliente", allEntries = true)
    @Transactional
    public ResponseEntity<ClienteApiDTO> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = new ClienteMapper().cadastrar(form);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteApiDTO(cliente));
    }

    @GetMapping("/api/clientes/report")
    @Cacheable(value = "relatorioCliente")
   public List<ClienteRelatorioProjection> relatorio(){
        return clienteRepository.findTotalDividasCobrancasPorNome();}

    @GetMapping("/{id}")
    public ClienteDetalhamentoDTO detalhamentoCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.getById(id);
        return new ClienteDetalhamentoDTO(cliente);
    }

    @GetMapping("/api/aW52YWxpZGEgcmVsYXTDs3JpbyBkZSBjbGllbnRlcw")
    @CacheEvict(value = "relatorioCliente", allEntries = true)
    public ResponseEntity<?> invalidacaoCache(){
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/api/clientes/{id}")
    public ResponseEntity remover(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/clientes/status/{id}")
    public ResponseEntity atualizaClienteStatus(@PathVariable Long id){
        Cliente cliente = clienteRepository.getById(id);
        cliente.atualizarStatus();
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }

}
