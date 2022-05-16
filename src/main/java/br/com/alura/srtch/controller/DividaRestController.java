package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.DividaApiDto;
import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.mapper.DividaMapper;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DividaApiDto> cadastrar(@RequestBody @Valid DividaForm dividaForm, UriComponentsBuilder uriBuilder){
        if(!clienteRepository.existsById(dividaForm.getCliente_id())){
            return ResponseEntity.badRequest().build();
        }

        Divida divida = new DividaMapper().cadastrar(dividaForm, clienteRepository);
        dividaRepository.save(divida);

        URI uri = uriBuilder.path("/api/dividas/{id}").buildAndExpand(divida.getId()).toUri();
        return ResponseEntity.created(uri).body(new DividaApiDto(divida));
    }
}
