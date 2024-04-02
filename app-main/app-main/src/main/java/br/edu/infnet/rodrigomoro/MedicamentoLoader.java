package br.edu.infnet.rodrigomoro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.rodrigomoro.model.domain.Endereco;
import br.edu.infnet.rodrigomoro.model.domain.Medicamento;
import br.edu.infnet.rodrigomoro.model.service.LocalidadeService;
import br.edu.infnet.rodrigomoro.model.service.MedicamentoService;

@Component
public class MedicamentoLoader implements ApplicationRunner {

    @Autowired
    private LocalidadeService localidadeService;
    @Autowired
    private MedicamentoService medicamentoService;
        
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Endereco enderecoMedicamento = localidadeService.obterPorCep("20041-005");

        medicamentoService.incluir(new Medicamento());

        medicamentoService.excluir(123);

        medicamentoService.incluir(new Medicamento(enderecoMedicamento));

        System.out.println(" - " + medicamentoService.obter(123));
                
        Medicamento medicamento = new Medicamento();
        medicamento.setCodigo(234);
        medicamento.setNome("Paracetamol");
        medicamento.setPreco(5.0f);
        medicamento.setControlado(false);
        medicamento.setEndereco(new Endereco("20010020", "Rua das Farmácias", "Farmácia 24h", "Centro", "Rio de Janeiro", "UF"));
        
        medicamentoService.incluir(medicamento);

        System.out.println(" - " + medicamentoService.obterLista());
    }
}
