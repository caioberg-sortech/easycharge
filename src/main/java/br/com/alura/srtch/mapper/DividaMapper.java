package br.com.alura.srtch.mapper;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.repository.ClienteRepository;

public class DividaMapper {

    public Divida transformaDividaForm(DividaForm dividaForm, ClienteRepository clienteRepository){
        Cliente cliente = clienteRepository.getById(dividaForm.getCliente_id());

        return new Divida(dividaForm.getValor(),dividaForm.getAbertura(),dividaForm.getStatus(),
                dividaForm.getQuitacao(),dividaForm.getDescricaoDeQuitacao(),cliente);
    }
}
