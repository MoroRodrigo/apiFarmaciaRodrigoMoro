package br.edu.infnet.rodrigomoro.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.rodrigomoro.model.domain.Medicamento;

@Repository
public interface MedicamentoRepository extends CrudRepository<Medicamento, Integer> {
    
    Medicamento findByCodigo(int codigo);
}
