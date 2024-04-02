package br.edu.infnet.rodrigomoro.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.rodrigomoro.model.domain.Farmacia;

@Repository
public interface FarmaciaRepository extends CrudRepository<Farmacia, Integer> {
    
    @Query("SELECT f FROM Farmacia f WHERE f.nome = :nome")
    Farmacia findByNome(String nome);
}