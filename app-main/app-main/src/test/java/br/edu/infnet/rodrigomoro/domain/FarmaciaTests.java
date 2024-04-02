package br.edu.infnet.rodrigomoro.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.rodrigomoro.model.domain.Endereco;
import br.edu.infnet.rodrigomoro.model.domain.Farmacia;
import br.edu.infnet.rodrigomoro.model.domain.Medicamento;

@SpringBootTest
class FarmaciaTest {
    
    private Farmacia farmacia;
    
    private Medicamento medicamento = new Medicamento();

    private final String EMAIL = "farmacia@farmacia.com";
    private final String NOME = "Farmacia XYZ";
    
    @BeforeEach
    void setUp() {
        
        List<Medicamento> medicamentos = new ArrayList<Medicamento>();
        medicamentos.add(medicamento);
        
        farmacia = new Farmacia();
        farmacia.setEmail(EMAIL);
        farmacia.setEndereco(new Endereco());
        farmacia.setNome(NOME);
        farmacia.setMedicamentos(medicamentos);
    }
    
    @Test
    void recuperarDados() {
        assertEquals(EMAIL, farmacia.getEmail());
        assertEquals(NOME, farmacia.getNome());
        assertEquals(new Endereco().getCep(), farmacia.getEndereco().getCep());
        assertTrue(farmacia.getMedicamentos().contains(medicamento));
    }
}
