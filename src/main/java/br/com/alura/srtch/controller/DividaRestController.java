package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.DividaApiDto;
import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.mapper.DividaMapper;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;
import br.com.alura.srtch.config.validation.DividaValidacao;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/dividas")
public class DividaRestController {

    private final DividaRepository dividaRepository;
    private final ClienteRepository clienteRepository;

    public DividaRestController(DividaRepository dividaRepository, ClienteRepository clienteRepository) {
        this.dividaRepository = dividaRepository;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    @CacheEvict(value = "relatorioCliente", allEntries = true)
    @Transactional
    public ResponseEntity<DividaApiDto> cadastrar(@RequestBody @Valid DividaForm dividaForm, UriComponentsBuilder uriBuilder){
        Long clienteId = dividaForm.getCliente_id();
        if(!clienteRepository.existsById(clienteId) ){
            return ResponseEntity.badRequest().build();
        } else  if(new DividaValidacao().validacaoValorDivida(clienteRepository,dividaRepository,clienteId, dividaForm.getValor())){
            return ResponseEntity.badRequest().build();
        }

        Divida divida = new DividaMapper().cadastrar(dividaForm, clienteRepository);
        dividaRepository.save(divida);

        URI uri = uriBuilder.path("/api/dividas/{id}").buildAndExpand(divida.getId()).toUri();
        return ResponseEntity.created(uri).body(new DividaApiDto(divida));
    }
}
