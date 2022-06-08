package br.com.alura.srtch.mapper;

import br.com.alura.srtch.form.CobrancaForm;
import br.com.alura.srtch.model.Cobranca;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.DividaRepository;

public class CobrancaMapper {

    public Cobranca trnsformaCobrancaForm(CobrancaForm cobrancaForm, DividaRepository dividaRepository){
        Divida divida = dividaRepository.getById(cobrancaForm.getDividaId());

        return new Cobranca(cobrancaForm.getDataCobranca(), cobrancaForm.getContato(), cobrancaForm.getAgente(),
                cobrancaForm.getTipoAgente(), cobrancaForm.getComentario(), cobrancaForm.getAcordo(),
                cobrancaForm.getTipoAcordo(), cobrancaForm.getDataPromessa(),cobrancaForm.getParcelas(), divida);
    }
}
