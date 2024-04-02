package br.edu.infnet.rodrigomoro.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.rodrigomoro.model.domain.Medicamento;
import br.edu.infnet.rodrigomoro.model.repository.MedicamentoRepository;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	public void incluir(Medicamento medicamento) {
		medicamentoRepository.save(medicamento);
	}
	
	public void excluir(int codigo) {
		// medicamentoRepository.deleteByCodigo(codigo);
		// Implemente este método se necessário, supondo que haja um método na interface MedicamentoRepository para exclusão por código.
	}
	
	public Collection<Medicamento> obterLista(){
		return (Collection<Medicamento>) medicamentoRepository.findAll();
	}
	
	public Medicamento obter(int codigo){
		return medicamentoRepository.findByCodigo(codigo);
	}
}
