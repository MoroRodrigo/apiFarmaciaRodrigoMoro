package br.edu.infnet.rodrigomoro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.rodrigomoro.model.domain.Medicamento;
import br.edu.infnet.rodrigomoro.model.service.MedicamentoService;

@SpringBootTest
public class MedicamentoServiceTests {

    @Autowired
    private MedicamentoService medicamentoService;
    
    private Medicamento medicamento;
    
    private final int CODIGO = 123;

    @BeforeEach
    void setUp() {
        medicamento = new Medicamento(CODIGO);
    }
    
    @Test
    void inclusao() {
        
        medicamentoService.incluir(medicamento);
        
        assertEquals(medicamento, medicamentoService.obter(CODIGO));
    }
    
    @Test
    void exclusao() {
        inclusao();
        
        medicamentoService.excluir(CODIGO);
        
        assertEquals(null, medicamentoService.obter(CODIGO));       
    }
    
    @Test
    void recuperacaoTotal() {
        inclusao();
        
        assertTrue(medicamentoService.obterLista().contains(medicamento));
    }
}
