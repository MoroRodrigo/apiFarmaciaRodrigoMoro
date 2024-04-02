package br.edu.infnet.rodrigomoro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.rodrigomoro.model.domain.Endereco;
import br.edu.infnet.rodrigomoro.model.domain.Farmacia;
import br.edu.infnet.rodrigomoro.model.service.FarmaciaService;
import br.edu.infnet.rodrigomoro.model.service.LocalidadeService;

@Component
public class FarmaciaLoader implements ApplicationRunner {

    @Autowired
    private LocalidadeService localidadeService;
    @Autowired
    private FarmaciaService farmaciaService;
        
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Endereco enderecoFarmacia = localidadeService.obterPorCep("22241900");

        farmaciaService.incluir(new Farmacia("Farmacia Popular", "farmaciapopular@farmacia", enderecoFarmacia));

        farmaciaService.excluir("Farmacia Popular");

        farmaciaService.incluir(new Farmacia("Farmacia ABC", "farmaciaabc@farmacia", enderecoFarmacia));

        System.out.println(" - " + farmaciaService.obter("Farmacia ABC"));
                
        farmaciaService.incluir(new Farmacia("Farmacia XYZ", "farmaciaxyz@farmacia", enderecoFarmacia));

        System.out.println(" - " + farmaciaService.obterLista());
    }
}
