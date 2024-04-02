package br.edu.infnet.rodrigomoro.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigomoro.model.domain.Farmacia;
import br.edu.infnet.rodrigomoro.model.repository.FarmaciaRepository;

@Service
public class FarmaciaService {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    public void incluir(Farmacia farmacia) {
        farmaciaRepository.save(farmacia);
    }

    public void excluir(String nome) {
        Farmacia farmacia = obter(nome);
        if (farmacia != null) {
            farmaciaRepository.delete(farmacia);
        }
    }

    public Collection<Farmacia> obterLista() {
        return (Collection<Farmacia>) farmaciaRepository.findAll();
    }

    public Farmacia obter(String nome) {
        return farmaciaRepository.findByNome(nome);
    }
}
