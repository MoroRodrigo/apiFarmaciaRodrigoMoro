package br.edu.infnet.rodrigomoro.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rodrigomoro.model.domain.Medicamento;
import br.edu.infnet.rodrigomoro.model.service.MedicamentoService;

@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoService medicamentoService;
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Medicamento medicamento) {
		medicamentoService.incluir(medicamento);
	}
	
	@DeleteMapping(value = "/{codigo}/excluir")
	public void excluir(@PathVariable int codigo) {
		medicamentoService.excluir(codigo);
	}
	
	@GetMapping(value = "/listar")
	public Collection<Medicamento> obterLista(){
		return medicamentoService.obterLista();
	}
	
	@GetMapping(value = "/{codigo}/listar")
	public Medicamento obter(@PathVariable int codigo){
		return medicamentoService.obter(codigo);
	}	
}
