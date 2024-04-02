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

import br.edu.infnet.rodrigomoro.model.domain.Farmacia;
import br.edu.infnet.rodrigomoro.model.service.FarmaciaService;

@RestController
@RequestMapping("/api/farmacia")
public class FarmaciaController {

	@Autowired
	private FarmaciaService farmaciaService;
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Farmacia farmacia) {
		farmaciaService.incluir(farmacia);
	}
	
	@DeleteMapping(value = "/{nome}/excluir")
	public void excluir(@PathVariable String nome) {
		farmaciaService.excluir(nome);
	}
	
	@GetMapping(value = "/listar")
	public Collection<Farmacia> obterLista(){
		return farmaciaService.obterLista();
	}
	
	@GetMapping(value = "/{nome}/listar")
	public Farmacia obter(@PathVariable String nome){
		return farmaciaService.obter(nome);
	}	
}
