package br.edu.infnet.rodrigomoro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.rodrigomoro.model.domain.Endereco;
import br.edu.infnet.rodrigomoro.model.domain.Farmacia;
import br.edu.infnet.rodrigomoro.model.service.FarmaciaService;

@SpringBootTest
public class FarmaciaServiceTests {

    @Autowired
    private FarmaciaService farmaciaService;
    
    private Farmacia farmacia;
    
    private final String NOME = "Farmacia XYZ";

    @BeforeEach
    void setUp() {
        farmacia = new Farmacia(NOME);
        farmacia.setEndereco(new Endereco());
    }
    
    @Test
    void inclusao() {
        
        farmaciaService.incluir(farmacia);
        
        assertEquals(farmacia, farmaciaService.obter(NOME));
    }
    
    @Test
    void exclusao() {
        inclusao();
        
        farmaciaService.excluir(NOME);
        
        assertEquals(null, farmaciaService.obter(NOME));       
    }
    
    @Test
    void recuperacaoTotal() {
        inclusao();
        
        assertTrue(farmaciaService.obterLista().contains(farmacia));
    }
}
