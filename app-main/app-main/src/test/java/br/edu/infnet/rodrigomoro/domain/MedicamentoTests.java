package br.edu.infnet.rodrigomoro.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.rodrigomoro.model.domain.Endereco;
import br.edu.infnet.rodrigomoro.model.domain.Medicamento;

@SpringBootTest
class MedicamentoTest {
    
    private Medicamento medicamento;

    private final String NOME = "Paracetamol";
    private final int CODIGO = 123;
    
    @BeforeEach
    void setUp() {
        medicamento = new Medicamento();
        medicamento.setNome(NOME);
        medicamento.setCodigo(CODIGO);
        medicamento.setControlado(false);
        medicamento.setPreco(0);
        medicamento.setEndereco(new Endereco());
    }

    @Test
    void recuperarDados() {
        assertEquals(NOME, medicamento.getNome());
        assertEquals(CODIGO, medicamento.getCodigo());
        assertEquals(false, medicamento.isControlado());
        assertEquals(0, medicamento.getPreco());
        assertEquals(new Endereco().getCep(), medicamento.getEndereco().getCep());
    }
}
