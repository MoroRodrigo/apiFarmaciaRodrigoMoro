package br.edu.infnet.rodrigomoro.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int codigo;
    private String nome;
    private float preco;
    private boolean controlado;
    @Transient
    private Endereco endereco;

    public Medicamento() {
        this.setCodigo(789);
        this.setNome("Paracetamol");
        this.setPreco(10.0f);
        this.setControlado(false);
        this.setEndereco(new Endereco("20010020", "Rua das Farmácias", "Farmácia 24h", "Centro", "Rio de Janeiro", "UF"));
    }

    public Medicamento(int codigo) {
        this();
        this.setCodigo(codigo);
    }

    public Medicamento(Endereco endereco) {
        this();
        this.setEndereco(endereco);
    }

    public float calcularPrecoComDesconto() {
        float precoComDesconto = preco;
        if (controlado) {
            precoComDesconto *= 0.9; // Desconto de 10% para medicamentos controlados
        }
        return precoComDesconto;
    }

    @Override
    public String toString() {
        return "Medicamento: " + id + " - " + codigo + " - " + nome + " - " + preco + " - " + controlado + " - " + endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isControlado() {
        return controlado;
    }

    public void setControlado(boolean controlado) {
        this.controlado = controlado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
