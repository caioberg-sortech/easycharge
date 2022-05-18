package br.com.alura.srtch.controller;

import br.com.alura.srtch.config.validation.DividaValidacao;
import br.com.alura.srtch.dto.CobrancaApiDto;
import br.com.alura.srtch.dto.DividaApiDto;
import br.com.alura.srtch.form.CobrancaForm;
import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.mapper.DividaMapper;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.CobrancasRepository;
import br.com.alura.srtch.repository.DividaRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/cobrancas")
public class CobrancasRestController {

    private final CobrancasRepository cobrancasRepository;
    private final ClienteRepository clienteRepository;
    private final DividaRepository dividaRepository;

    public CobrancasRestController(CobrancasRepository cobrancasRepository, ClienteRepository clienteRepository, DividaRepository dividaRepository) {
        this.cobrancasRepository = cobrancasRepository;
        this.clienteRepository = clienteRepository;
        this.dividaRepository = dividaRepository;
    }


    @PostMapping
    @CacheEvict(value = "relatorioCliente", allEntries = true)
    @Transactional
    public ResponseEntity<CobrancaApiDto> cadastrar(@RequestBody @Valid CobrancaForm cobrancaForm, UriComponentsBuilder uriBuilder){
        Long clienteId = cobrancaForm.getDividaId();
        if(!dividaRepository.existsById(clienteId) ){
            return ResponseEntity.badRequest().build();
        }

        URI uri = uriBuilder.path("/api/cobrancas/{id}").buildAndExpand(divida.getId()).toUri();
        return ResponseEntity.created(uri).body(new DividaApiDto(divida));
    }
}
