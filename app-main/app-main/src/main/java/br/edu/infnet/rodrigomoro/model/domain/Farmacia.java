package br.edu.infnet.rodrigomoro.model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Farmacia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    @Transient
    private List<Medicamento> medicamentos;
    @Transient
    private Endereco endereco;

    public Farmacia() {
        this.setNome("Farmácia Popular");
        this.setEmail("atendimento@farmaciapopular.com");
        this.setEndereco(new Endereco());
        this.setMedicamentos(new ArrayList<Medicamento>(Arrays.asList(new Medicamento())));
    }

    public Farmacia(String nome) {
        this();
        this.setNome(nome);
    }

    public Farmacia(String nome, String email) {
        this(nome);
        this.setEmail(email);
    }

    public Farmacia(String nome, String email, Endereco endereco) {
        this(nome, email);
        this.setEndereco(endereco);
    }

    @Override
    public String toString() {
        return "Farmacia: " + id + " - " + nome + " - " + email + " - " + endereco + " - " + medicamentos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
